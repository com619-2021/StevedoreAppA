package uk.ac.solent.devops.impl.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uk.ac.solent.devops.impl.validator.UserValidator;
import uk.ac.solent.devops.model.user.service.SecurityService;
import uk.ac.solent.devops.model.user.service.UserService;

import java.util.Collection;

@Controller
@Transactional
public class ResourceController {

    final static Logger LOG = LogManager.getLogger(ResourceController.class);

    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    public ResourceController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = {"/resource"}, method = RequestMethod.GET)
    public String resources(Model model) {
        LOG.debug("resource called:");

        model.addAttribute("selectedPage", "resource");
        return "resources";
    }

    @RequestMapping(value = {"/viewModifyResource"}, method = RequestMethod.GET)
    public String viewResource(Model model, @RequestParam(value = "abstractResourceUuid", required = true) String abstractResourceUuid, Authentication authentication) {
        /*
        LOG.debug("/viewModifyResource: abstractResourceUuid:" + abstractResourceUuid);
        String errorMessage = "";
        String message = "";

        Resource abstractResource = new Resource();
        List<Characteristic> abstractCharacteristics = new ArrayList();

        // popultate model
        List<Resource> resourceList = new ArrayList();
        ReplyMessage replyMessage = resourceService.getResourceByuuid(abstractResourceUuid);
        if (replyMessage.getResourceList() != null && !replyMessage.getResourceList().isEmpty()) {
            resourceList = replyMessage.getResourceList();
            abstractResource = resourceList.get(0);
            abstractCharacteristics = (abstractResource.getCharacteristics() != null) ? abstractResource.getCharacteristics() : abstractCharacteristics;
        } else {
            errorMessage = "error getting resource" + replyMessage.getDebugMessage();
            model.addAttribute("errorMessage", errorMessage);
        }

        model.addAttribute("abstractResourceSize", resourceList.size());
        model.addAttribute("abstractResource", abstractResource);
        model.addAttribute("abstractCharacteristics", abstractCharacteristics);

        // add message if there are any 
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("message", message);

        model.addAttribute("selectedPage", "resources");

         */
        return "viewModifyResource";
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

}
