package uk.ca.solent.devops.stevedore.controller.rest.ros;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ca.solent.devops.stevedore.controller.rest.base.StevedoreApiController;
import uk.ca.solent.devops.stevedore.model.ros.ResourceOrServiceModel;
import uk.ca.solent.devops.stevedore.service.ros.ResourceOrServiceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/orderchange", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResourceOrServiceController implements StevedoreApiController<ResourceOrServiceModel> {

    private final ResourceOrServiceService resourceOrServiceService;

    public ResourceOrServiceController(ResourceOrServiceService resourceOrServiceService) {
        this.resourceOrServiceService = resourceOrServiceService;
    }

    @Override
    @PostMapping
    public void Add(@RequestBody ResourceOrServiceModel model) {
        resourceOrServiceService.Add(model);
    }

    @Override
    @GetMapping
    public List<ResourceOrServiceModel> GetAll() {
        return resourceOrServiceService.Get();
    }

    @Override
    @GetMapping("/{id}")
    public ResourceOrServiceModel Get(@PathVariable int id) {
        return resourceOrServiceService.Get(id);
    }

    @Override
    @GetMapping("/{uuid}")
    public ResourceOrServiceModel Get(@PathVariable UUID uuid) {
        return resourceOrServiceService.Get(uuid);
    }

    @Override
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id) {
        resourceOrServiceService.Delete(id);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void Delete(@PathVariable UUID uuid) {
        resourceOrServiceService.Delete(uuid);
    }

    @Override
    @PutMapping
    public ResourceOrServiceModel Update(@RequestBody ResourceOrServiceModel updateModel) {
        return resourceOrServiceService.Update(updateModel);
    }
}
