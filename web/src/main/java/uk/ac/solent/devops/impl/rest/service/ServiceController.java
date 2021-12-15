package uk.ac.solent.devops.impl.rest.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import uk.ac.solent.devops.impl.dao.service.springdata.ServiceRepository;
import uk.ac.solent.devops.impl.rest.base.ControllerBase;
import uk.ac.solent.devops.model.service.ResourceType;
import uk.ac.solent.devops.model.service.dto.ServiceModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class ServiceController implements ControllerBase<ServiceModel> {

    private final ServiceRepository serviceRepository;

    private static final List<ServiceModel> serviceData = new ArrayList<>();

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    static {
        serviceData.add(ServiceModel.builder().resourceType(ResourceType.INTERNAL).value("10000").name("Water").build());
    }

    @Override
    @PostMapping("/api/service")
    public void add(ServiceModel model) {
        serviceData.add(model);
    }

    @Override
    @GetMapping(value = "/api/service", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public List<ServiceModel> get() {
        return serviceData;
    }

    @Override
    @GetMapping(value = "/api/service/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public ServiceModel get(@PathVariable long id) {
        return serviceData.stream().filter(serviceModel -> serviceModel.getId() == id).findFirst().orElse(null);
    }

    @Override
    @GetMapping(value = "/api/service/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public ServiceModel get(@PathVariable UUID uuid) {
        return serviceData.stream().filter(serviceModel -> serviceModel.getUuid() == uuid).findFirst().orElse(null);
    }

    @Override
    @DeleteMapping(value = "/api/service/{id}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable long id) {
        serviceData.stream().filter(order -> order.getId() == id).findFirst().ifPresent(serviceData::remove);
    }

    @Override
    @DeleteMapping(value = "/api/service/{uuid}", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable UUID uuid) {
        serviceData.stream().filter(order -> order.getUuid() == uuid).findFirst().ifPresent(serviceData::remove);
    }

    @Override
    @PutMapping(value = "/api/service", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ServiceModel update(ServiceModel updateModel) {
        ServiceModel serviceModel1 = serviceData.stream().filter(order -> Objects.equals(order.getId(), updateModel.getId())).findFirst().orElse(null);
        serviceData.set(serviceData.indexOf(serviceModel1), updateModel);
        return updateModel;
    }

}
