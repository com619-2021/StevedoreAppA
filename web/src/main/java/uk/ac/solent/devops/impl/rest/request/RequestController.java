package uk.ac.solent.devops.impl.rest.request;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.request.springdata.OrderChangeRequestRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;

import java.util.List;
import java.util.UUID;

@RestController
public class RequestController implements ControllerBase<OrderChangeRequest> {

    private final OrderChangeRequestRepository orderChangeRequestRepository;

    public RequestController(OrderChangeRequestRepository orderChangeRequestRepository) {
        this.orderChangeRequestRepository = orderChangeRequestRepository;
    }

    @Override
    @PostMapping("/api/ocr")
    public void add(OrderChangeRequest model) {

    }

    @Override
    @GetMapping(value = "/api/ocr", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<OrderChangeRequest> get() {
        return null;
    }

    @Override
    @GetMapping(value = "/api/ocr/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public OrderChangeRequest get(@PathVariable long id) {
        return null;
    }

    @Override
    @GetMapping(value = "/api/ocr/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public OrderChangeRequest get(@PathVariable UUID uuid) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/api/ocr/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {

    }

    @Override
    @DeleteMapping(value = "/api/ocr/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID id) {

    }

    @Override
    @PutMapping(value = "/api/ocr", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OrderChangeRequest update(OrderChangeRequest updateModel) {
        return null;
    }
}