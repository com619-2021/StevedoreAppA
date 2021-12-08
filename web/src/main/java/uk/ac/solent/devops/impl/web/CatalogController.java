package uk.ac.solent.devops.impl.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.party.service.PartyService;
import uk.ac.solent.devops.model.resource.dto.Characteristic;
import uk.ac.solent.devops.model.resource.dto.ResourceAccess;
import uk.ac.solent.devops.model.resource.dto.ResourceCatalog;
import uk.ac.solent.devops.model.resource.service.ResourceCatalogService;
import uk.ac.solent.devops.model.resource.service.ResourceInventoryService;
import uk.ac.solent.devops.model.user.dto.Role;
import uk.ac.solent.devops.model.user.dto.User;
import uk.ac.solent.devops.model.user.service.SecurityService;
import uk.ac.solent.devops.model.user.service.UserService;

import java.util.*;

@Controller
@Transactional
public class CatalogController {

    final static Logger LOG = LogManager.getLogger(CatalogController.class);

    {
        LOG.debug("CatalogController created");
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ResourceCatalogService resourceCatalogService = null;

    @Autowired
    private ResourceInventoryService resourceService = null;

    // ***************************
    // Methods to modify catalog
    // ***************************
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/catalog"}, method = RequestMethod.GET)
    public String catalog(Model model) {
        LOG.debug("catalog called:");
        ReplyMessage reply = resourceCatalogService.getResourceCatalogByTemplate(null, 0, 20);
        List<ResourceCatalog> resourceCatalogList = reply.getResourceCatalogList();

        model.addAttribute("abstractResourceSize", resourceCatalogList.size());
        model.addAttribute("abstractResourceList", resourceCatalogList);

        model.addAttribute("selectedPage", "catalog");
        return "catalog";
    }

    @RequestMapping(value = {"/viewModifyCatalog"}, method = RequestMethod.GET)
    public String viewcatalog(Model model,
            @RequestParam(value = "abstractResourceUuid", required = true) String abstractResourceUuid, Authentication authentication) {

        LOG.debug("/viewModifyCatalog: abstractResourceUuid:" + abstractResourceUuid);
        String errorMessage = "";
        String message = "";

        ResourceCatalog abstractResource = new ResourceCatalog();
        List<Characteristic> abstractCharacteristics = new ArrayList();

        // populate model
        List<ResourceCatalog> resourceList = new ArrayList();
        ReplyMessage replyMessage = resourceCatalogService.getResourceCatalogByuuid(abstractResourceUuid);
        if (replyMessage.getResourceCatalogList() != null && !replyMessage.getResourceCatalogList().isEmpty()) {
            resourceList = replyMessage.getResourceCatalogList();
            abstractResource = resourceList.get(0);
            abstractCharacteristics = (abstractResource.getCharacteristics() != null) ? abstractResource.getCharacteristics() : abstractCharacteristics;
        } else {
            errorMessage = "error getting catalog entity resource abstractResourceUuid = "+abstractResourceUuid
                    + " debug message: " + replyMessage.getDebugMessage();
            model.addAttribute("errorMessage", errorMessage);
        }

        model.addAttribute("abstractResourceSize", resourceList.size());
        model.addAttribute("abstractResource", abstractResource);
        model.addAttribute("abstractCharacteristics", abstractCharacteristics);

        // add message if there are any 
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("message", message);

        model.addAttribute("selectedPage", "catalog");
        return "viewModifyCatalog";
    }

    @RequestMapping(value = {"/viewModifyCatalog"}, method = RequestMethod.POST)
    public String updatecatalog(Model model,
            @RequestParam(value = "action", required = true) String action,
            @RequestParam(value = "abstractResourceUuid", required = false) String abstractResourceUuid,
            @RequestParam(value = "abstractResourceName", required = false) String abstractResourceName,
            @RequestParam(value = "abstractTypeName", required = false) String abstractTypeName,
            @RequestParam(value = "abstractResourceHref", required = false) String abstractResourceHref,
            @RequestParam(value = "abstractResourceResourceController", required = false) String abstractResourceResourceController,
            @RequestParam(value = "abstractResourceDescription", required = false) String abstractResourceDescription,
            @RequestParam(value = "characteristicName", required = false) String characteristicName,
            @RequestParam(value = "characteristicValue", required = false) String characteristicValue,
            @RequestParam(value = "characteristicDescription", required = false) String characteristicDescription,
            @RequestParam(value = "ownerPartyUUID", required = false) String ownerPartyUUID,
            Authentication authentication) {

        LOG.debug("/viewModifyCatalog: abstractResourceUuid:" + abstractResourceUuid);

        String errorMessage = "";
        String message = "";

        ResourceCatalog abstractResource = new ResourceCatalog();
        List<Characteristic> abstractCharacteristics = new ArrayList();
        ReplyMessage replyMessage;

        // perform actions
        if ("createAbstractResource".equals(action)) {
            replyMessage = resourceCatalogService.postCreateResourceCatalog(abstractResource);
            if (replyMessage.getResourceCatalogList() != null && !replyMessage.getResourceCatalogList().isEmpty()) {
                abstractResource = replyMessage.getResourceCatalogList().get(0);
                abstractResourceUuid = abstractResource.getUuid();
                LOG.debug("new catalog entry created uuid=" + abstractResourceUuid);
                message = "success created";
            } else {
                errorMessage = "error creating catalog item" + replyMessage.getDebugMessage();
            }
            LOG.debug("created Catalog entry: abstractResourceUuid=" + abstractResourceUuid);

        } else if ("updateAbstractResource".equals(action)) {
            ResourceCatalog resource = new ResourceCatalog();
            resource.setUuid(abstractResourceUuid);
            resource.setName(abstractResourceName);
            resource.setResourceTypeName(abstractTypeName);
            resource.setHref(abstractResourceHref);
            ResourceAccess resourceAccess = ResourceAccess.valueOf(abstractResourceResourceController);
            resource.setResourceController(resourceAccess);
            resource.setDescription(abstractResourceDescription);

            resourceCatalogService.putUpdateResourceCatalog(resource);
            message = "success updated";

        } else if ("deleteAbstractResource".equals(action)) {
            replyMessage = resourceCatalogService.deleteResourceCatalogByUuid(abstractResourceUuid);
            return "redirect:/resources";

        } else if ("deleteCharacteristic".equals(action)) {
            replyMessage = resourceCatalogService.postRemoveCharacteristic(abstractResourceUuid, characteristicName);
            message = "success characteristic " + characteristicName + " deleted";

        } else if ("updateCharacteristic".equals(action)) {
            replyMessage = resourceCatalogService.postAddModifyCharacteristic(abstractResourceUuid, characteristicName, characteristicValue, characteristicDescription);
            message = "success characteristic " + characteristicName + " updated";

        } else if ("createCharacteristic".equals(action)) {
            if (characteristicName.isEmpty()) {
                errorMessage = "characteristic name cannot be blank";
            } else {
                replyMessage = resourceCatalogService.postAddModifyCharacteristic(abstractResourceUuid, characteristicName, characteristicValue, characteristicDescription);
                message = "success characteristic " + characteristicName + " added";
            }
        }

        // populate model
        List<ResourceCatalog> resourceCatalogList = new ArrayList();
        replyMessage = resourceCatalogService.getResourceCatalogByuuid(abstractResourceUuid);
        if (replyMessage.getResourceCatalogList() != null && !replyMessage.getResourceCatalogList().isEmpty()) {
            resourceCatalogList = replyMessage.getResourceCatalogList();
            abstractResource = resourceCatalogList.get(0);
            abstractCharacteristics = (abstractResource.getCharacteristics() != null) ? abstractResource.getCharacteristics() : abstractCharacteristics;
        } else {
            errorMessage = "error accessing catalog item abstractResourceUuid: " + abstractResourceUuid
                    + " reply debug message=" + replyMessage.getDebugMessage();
        }
        model.addAttribute("abstractResourceSize", resourceCatalogList.size());
        model.addAttribute("abstractResource", abstractResource);
        model.addAttribute("abstractCharacteristics", abstractCharacteristics);

        // add message if there are any 
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("message", message);

        model.addAttribute("selectedPage", "catalog");
        return "viewModifyCatalog";
    }

    private Map<String, String> selectedRolesMap(User user) {

        List<String> availableRoles = userService.getAvailableUserRoleNames();

        List<String> selectedRoles = new ArrayList();
        for (Role role : user.getRoles()) {
            selectedRoles.add(role.getName());
            LOG.debug("user " + user.toString()
                    + "roles from database:" + role.getName());
        }

        Map<String, String> selectedRolesMap = new LinkedHashMap();
        for (String availableRole : availableRoles) {
            if (selectedRoles.contains(availableRole)) {
                selectedRolesMap.put(availableRole, "checked");
                LOG.debug("availableRole " + availableRole
                        + " user " + user.toString() + " available role:checked");
            } else {
                selectedRolesMap.put(availableRole, "");
                LOG.debug("availableRole " + availableRole
                        + " user " + user.toString() + " available role:not checked");
            }
        }

        return selectedRolesMap;

    }

    /**
     * returns true if the party has the role specified
     *
     * @param role
     * @return
     */
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
