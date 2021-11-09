package uk.ca.solent.devops.stevedore.controller.rest.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ca.solent.devops.stevedore.controller.rest.base.StevedoreApiController;
import uk.ca.solent.devops.stevedore.model.order.OrderModel;
import uk.ca.solent.devops.stevedore.service.order.OrderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController implements StevedoreApiController<OrderModel> {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    @PostMapping
    public void Add(@RequestBody OrderModel model) {
        orderService.Add(model);
    }

    @Override
    @GetMapping
    public List<OrderModel> GetAll() {
        return orderService.Get();
    }

    @Override
    @GetMapping("/{id}")
    public OrderModel Get(@PathVariable int id) {
        return orderService.Get(id);
    }

    @Override
    @GetMapping("/{uuid}")
    public OrderModel Get(@PathVariable UUID uuid) {
        return orderService.Get(uuid);
    }

    @Override
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable long id) {
        orderService.Delete(id);
    }

    @Override
    @DeleteMapping("/{uuid}")
    public void Delete(@PathVariable UUID uuid) {
        orderService.Delete(uuid);
    }

    @Override
    @PutMapping
    public OrderModel Update(@RequestBody OrderModel updateModel) {
        return orderService.Update(updateModel);
    }
}
