package uk.ac.solent.devops.impl.rest.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.order.springdata.OrderRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.order.dto.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController implements ControllerBase<Order> {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @PostMapping("/api/order")
    public void add(Order model) {

    }

    @Override
    @GetMapping(value = "/api/order", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<Order> get() {
        return new ArrayList<Order>(){{
            add(new Order());
        }};
    }

    @Override
    @GetMapping(value = "/api/order/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Order get(@PathVariable long id) {
        return null;
    }

    @Override
    @GetMapping(value = "/api/order/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Order get(@PathVariable UUID uuid) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/api/order/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {

    }

    @Override
    @DeleteMapping(value = "/api/order/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID uuid) {

    }

    @Override
    @PutMapping(value = "/api/order", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Order update(Order updateModel) {
        return null;
    }

}