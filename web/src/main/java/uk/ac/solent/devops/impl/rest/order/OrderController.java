package uk.ac.solent.devops.impl.rest.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.order.springdata.OrderRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.order.OrderStatus;
import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.service.ResourceType;

import java.util.*;

@RestController
public class OrderController implements ControllerBase<Order> {

    private final OrderRepository orderRepository;

    private static final List<Order> orderData = new ArrayList<>();

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    static {
        orderData.add(Order.builder()
                .orderStatus(OrderStatus.CONFIRMED)
                .orderType(ResourceType.INTERNAL)
                .description("TestDescription")
                .name("Test")
                .uuid(UUID.randomUUID())
                .orderDate(new Date())
                .endDate(new Date())
                .build());
    }

    @Override
    @PostMapping("/api/order")
    public void add(Order model) {
        orderData.add(model);
    }

    @Override
    @GetMapping(value = "/api/order", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<Order> get() {
        return orderData;
    }

    @Override
    @GetMapping(value = "/api/order/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Order get(@PathVariable long id) {
        return orderData.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }

    @Override
    @GetMapping(value = "/api/order/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Order get(@PathVariable UUID uuid) {
        return orderData.stream().filter(order -> order.getUuid() == uuid).findFirst().orElse(null);
    }

    @Override
    @DeleteMapping(value = "/api/order/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {
        orderData.stream().filter(order -> order.getId() == id).findFirst().ifPresent(orderData::remove);
    }

    @Override
    @DeleteMapping(value = "/api/order/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID uuid) {
        orderData.stream().filter(order -> order.getUuid() == uuid).findFirst().ifPresent(orderData::remove);
    }

    @Override
    @PutMapping(value = "/api/order", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Order update(Order updateModel) {
        Order order1 = orderData.stream().filter(order -> Objects.equals(order.getId(), updateModel.getId())).findFirst().orElse(null);
        orderData.set(orderData.indexOf(order1), updateModel);
        return updateModel;
    }

}