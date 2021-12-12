package uk.ac.solent.devops.impl.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.validator.UserValidator;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;
import uk.ac.solent.devops.model.user.dto.UserRoles;
import uk.ac.solent.devops.model.user.service.SecurityService;
import uk.ac.solent.devops.model.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

@Controller
@Transactional
public class UserController {

    final static Logger LOG = LogManager.getLogger(UserController.class);

    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) return "registration";

        userService.create(userForm);

        if (!hasRole(UserRoles.ROLE_USER.name())) {
            LOG.debug("creating new user and logging in : " + userForm);
            securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        } else {
            LOG.debug("creating new user : " + userForm);
        }

        return "redirect:/viewModifyUser?username=" + userForm.getUsername();
    }

    @RequestMapping(value = "/denied", method = {RequestMethod.GET, RequestMethod.POST})
    public String denied(Model model) {
        return "denied";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, String error, String logout) {
        if (error != null) model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null) model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    // this redirects calls to the root of our application to index.html
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        return "redirect:/index.html";
    }

    @RequestMapping(value = {"/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public String about(Model model) {
        return "about";
    }

    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public String contact(Model model) {
        return "contact";
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String users(Model model) {
        List<User> userList = userService.findAll();

        LOG.debug("users called:");

        userList.forEach(x -> LOG.debug(" user:" + x));

        model.addAttribute("userListSize", userList.size());
        model.addAttribute("userList", userList);

        return "users";
    }

    @RequestMapping(value = {"/viewModifyUser"}, method = RequestMethod.GET)
    public String modifyUser(Model model,
                             @RequestParam(value = "username") String username, Authentication authentication) {

        if (!hasRole(UserRoles.ROLE_GLOBAL_ADMIN.name())) {
            if (!username.equals(authentication.getName())) {
                LOG.warn("security warning without permissions, modifyuser called for username=" + username);
                return ("denied");
            }
        }

        User user = userService.findByUsername(username);
        if (user == null) {
            LOG.warn("security warning modifyuser called for unknown username=" + username);
            return ("denied");
        }

        LOG.debug("viewUser called for username=" + username + " user=" + user);
        model.addAttribute("user", user);

        Map<String, String> selectedRolesMap = selectedRolesMap(user);

        selectedRolesMap.forEach((key, value) -> LOG.debug(username + " role:" + key + " selected:" + value));


        model.addAttribute("selectedRolesMap", selectedRolesMap);

        return "viewModifyUser";
    }

    @RequestMapping(value = {"/viewModifyUser"}, method = RequestMethod.POST)
    public String updateuser(Model model,
                             @RequestParam(value = "username", required = true) String username,
                             @RequestParam(value = "firstName", required = false) String firstName,
                             @RequestParam(value = "secondName", required = false) String secondName,
                             @RequestParam(value = "selectedRoles", required = false) List<String> selectedRolesIn,
                             @RequestParam(value = "userEnabled", required = false) String userEnabled,
                             @RequestParam(value = "number", required = false) String number,
                             @RequestParam(value = "addressLine1", required = false) String addressLine1,
                             @RequestParam(value = "addressLine2", required = false) String addressLine2,
                             @RequestParam(value = "county", required = false) String county,
                             @RequestParam(value = "country", required = false) String country,
                             @RequestParam(value = "postcode", required = false) String postcode,
                             @RequestParam(value = "latitude", required = false) String latitude,
                             @RequestParam(value = "longitude", required = false) String longitude,
                             @RequestParam(value = "telephone", required = false) String telephone,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             Authentication authentication
    ) {
        LOG.debug("updateUser called for username=" + username);

        if (!hasRole(UserRoles.ROLE_GLOBAL_ADMIN.name())) {
            if (!username.equals(authentication.getName())) {
                LOG.warn("security warning without permissions, updateUser called for username=" + username);
                return ("denied");
            }
        }

        User user = userService.findByUsername(username);
        if (user == null) {
            LOG.warn("security warning updateUser called for unknown username=" + username);
            return ("denied");
        }

        String errorMessage = "";

        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (secondName != null) {
            user.setSecondName(secondName);
        }
        if (userEnabled != null) {
            user.setEnabled(Boolean.TRUE);
        } else {
            user.setEnabled(Boolean.FALSE);
        }

        user = userService.save(user);

        if (selectedRolesIn != null) {
            user = userService.updateUserRoles(username, selectedRolesIn);
        }

        Map<String, String> selectedRolesMap = selectedRolesMap(user);

        model.addAttribute("user", user);

        model.addAttribute("selectedRolesMap", selectedRolesMap);

        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("message", "User " + user.getUsername() + " updated successfully");

        return "viewModifyUser";
    }

    private Map<String, String> selectedRolesMap(User user) {

        List<String> availableRoles = userService.getAvailableUserRoleNames();

        List<String> selectedRoles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            selectedRoles.add(role.getName());
            LOG.debug("user " + user
                    + "roles from database:" + role.getName());
        }

        Map<String, String> selectedRolesMap = new LinkedHashMap<>();
        for (String availableRole : availableRoles) {
            if (selectedRoles.contains(availableRole)) {
                selectedRolesMap.put(availableRole, "checked");
                LOG.debug("availableRole " + availableRole
                        + " user " + user + " available role:checked");
            } else {
                selectedRolesMap.put(availableRole, "");
                LOG.debug("availableRole " + availableRole
                        + " user " + user + " available role:not checked");
            }
        }

        return selectedRolesMap;

    }

    private boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities
                = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }


    @RequestMapping(value = {"/addUsersToParty"}, method = RequestMethod.POST)
    public String addUsersToParty(Model model, @RequestParam(value = "partyuuid", required = false) String partyUuid) {
        List<User> userList = userService.findAll();

        LOG.debug("addUsersToParty called:");
        for (User user : userList) {
            LOG.debug(" user:" + user);
        }

        model.addAttribute("userListSize", userList.size());
        model.addAttribute("userList", userList);
        model.addAttribute("partyuuid", partyUuid);

        return "addUsersToParty";
    }


    /*
     * Default exception handler, catches all exceptions, redirects to friendly
     * error page. Does not catch request mapping errors
     */
    @ExceptionHandler(Exception.class)
    public String myExceptionHandler(final Exception e, Model model, HttpServletRequest request) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        final String strStackTrace = sw.toString(); // stack trace as a string
        String urlStr = "not defined";
        if (request != null) {
            StringBuffer url = request.getRequestURL();
            urlStr = url.toString();
        }
        model.addAttribute("requestUrl", urlStr);
        model.addAttribute("strStackTrace", strStackTrace);
        model.addAttribute("exception", e);
        //logger.error(strStackTrace); // send to logger first
        return "error"; // default friendly exception message for user
    }

}
