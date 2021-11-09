package uk.ca.solent.devops.stevedore.controller.rest.request;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ca.solent.devops.stevedore.controller.rest.base.StevedoreApiController;
import uk.ca.solent.devops.stevedore.model.request.OrderChangeRequestModel;
import uk.ca.solent.devops.stevedore.service.request.OrderChangeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/resource", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderChangeController implements StevedoreApiController<OrderChangeRequestModel> {

    private final OrderChangeService changeService;

    public OrderChangeController(OrderChangeService changeService) {
        this.changeService = changeService;
    }

    @Override
    @PostMapping
    public void Add(@RequestBody OrderChangeRequestModel model) {
        changeService.Add(model);
    }

    @Override
    @GetMapping
    public List<OrderChangeRequestModel> GetAll() {
        return changeService.Get();
    }

    @Override
    @GetMapping("/{id}")
    public OrderChangeRequestModel Get(@PathVariable int id) {
        return changeService.Get(id);
    }

    @Override
    @GetMapping("/{uuid}")
    public OrderChangeRequestModel Get(@PathVariable UUID uuid) {
        return changeService.Get(uuid);
    }

    @Override
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id) {
        changeService.Delete(id);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void Delete(@PathVariable UUID uuid) {
        changeService.Delete(uuid);
    }

    @Override
    @PutMapping
    public OrderChangeRequestModel Update(@RequestBody OrderChangeRequestModel updateModel) {
        return changeService.Update(updateModel);
    }
}
