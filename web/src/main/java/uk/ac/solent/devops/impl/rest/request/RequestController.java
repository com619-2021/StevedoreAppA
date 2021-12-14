package uk.ac.solent.devops.impl.rest.request;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.request.springdata.OrderChangeRequestRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.request.ChangeStatus;
import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;

import java.util.*;

@RestController
public class RequestController implements ControllerBase<OrderChangeRequest> {

    private final OrderChangeRequestRepository orderChangeRequestRepository;

    private static List<OrderChangeRequest> orderChangeData = new ArrayList<>();

    public RequestController(OrderChangeRequestRepository orderChangeRequestRepository) {
        this.orderChangeRequestRepository = orderChangeRequestRepository;
    }

    static {
        orderChangeData.add(OrderChangeRequest.builder().requestDate(new Date()).changeReason("TestChange").uuid(UUID.randomUUID()).changeStatus(ChangeStatus.REQUESTED).requestDate(new Date()).build());
    }

    @Override
    @PostMapping("/api/ocr")
    public void add(OrderChangeRequest model) {
        orderChangeData.add(model);
    }

    @Override
    @GetMapping(value = "/api/ocr", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<OrderChangeRequest> get() {
        return orderChangeData;
    }

    @Override
    @GetMapping(value = "/api/ocr/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public OrderChangeRequest get(@PathVariable long id) {
        return orderChangeData.stream().filter(orderChangeRequest -> orderChangeRequest.getId() == id).findFirst().orElse(null);

    }

    @Override
    @GetMapping(value = "/api/ocr/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public OrderChangeRequest get(@PathVariable UUID uuid) {
        return orderChangeData.stream().filter(orderChangeRequest -> orderChangeRequest.getUuid() == uuid).findFirst().orElse(null);

    }

    @Override
    @DeleteMapping(value = "/api/ocr/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {
        orderChangeData.stream().filter(orderChangeRequest -> orderChangeRequest.getId() == id).findFirst().ifPresent(orderChangeData::remove);
    }

    @Override
    @DeleteMapping(value = "/api/ocr/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID uuid) {
        orderChangeData.stream().filter(orderChangeRequest -> orderChangeRequest.getUuid() == uuid).findFirst().ifPresent(orderChangeData::remove);
    }

    @Override
    @PutMapping(value = "/api/ocr", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OrderChangeRequest update(OrderChangeRequest updateModel) {
        OrderChangeRequest order1 = orderChangeData.stream().filter(order -> Objects.equals(order.getId(), updateModel.getId())).findFirst().orElse(null);
        orderChangeData.set(orderChangeData.indexOf(order1), updateModel);
        return updateModel;
    }
}