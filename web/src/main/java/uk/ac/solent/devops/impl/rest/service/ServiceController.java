package uk.ac.solent.devops.impl.rest.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.service.springdata.ServiceRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.service.dto.ServiceModel;

import java.util.List;
import java.util.UUID;

@RestController
public class ServiceController implements ControllerBase<ServiceModel> {

    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    @PostMapping("/api/service")
    public void add(ServiceModel model) {

    }

    @Override
    @GetMapping(value = "/api/service", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<ServiceModel> get() {
        return null;
    }

    @Override
    @GetMapping(value = "/api/service/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public ServiceModel get(@PathVariable long id) {
        return null;
    }

    @Override
    @GetMapping(value = "/api/service/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public ServiceModel get(@PathVariable UUID uuid) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/api/service/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {

    }

    @Override
    @DeleteMapping(value = "/api/service/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID id) {

    }

    @Override
    @PutMapping(value = "/api/service", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ServiceModel update(ServiceModel updateModel) {
        return null;
    }

}
