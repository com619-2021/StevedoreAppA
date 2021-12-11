package uk.ac.solent.devops.impl.service;

import org.springframework.stereotype.Service;
import uk.ac.solent.devops.impl.dao.service.springdata.ServiceRepository;
import uk.ac.solent.devops.model.service.dto.ServiceModel;
import uk.ac.solent.devops.model.service.service.ServiceModelService;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceModelServiceImpl implements ServiceModelService {

    private final ServiceRepository serviceModel;

    public ServiceModelServiceImpl(ServiceRepository serviceModel) {
        this.serviceModel = serviceModel;
    }

    @Override
    public ServiceModel create(ServiceModel user) {
        return null;
    }

    @Override
    public ServiceModel findByUuid(UUID uuid) {
        return null;
    }

    @Override
    public List<ServiceModel> findAll() {
        return null;
    }

    @Override
    public ServiceModel save(ServiceModel user) {
        return null;
    }
}
