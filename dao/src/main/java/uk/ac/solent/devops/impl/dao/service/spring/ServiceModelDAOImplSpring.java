package uk.ac.solent.devops.impl.dao.service.spring;

import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.service.springdata.ServiceRepository;
import uk.ac.solent.devops.model.service.dao.ServiceModelDAO;
import uk.ac.solent.devops.model.service.dto.ServiceModel;

import java.util.List;
import java.util.UUID;

@Component
public class ServiceModelDAOImplSpring implements ServiceModelDAO {

    private final ServiceRepository serviceRepository;

    public ServiceModelDAOImplSpring(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceModel findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceModel save(ServiceModel service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<ServiceModel> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void delete(ServiceModel serviceModel) {
        serviceRepository.delete(serviceModel);
    }

    @Override
    public void deleteAll() {
        serviceRepository.deleteAll();
    }

    @Override
    public ServiceModel findByRoleUuid(UUID uuid) {
        return serviceRepository.findAll().stream().filter(x -> x.getUuid().equals(uuid)).findFirst().orElse(null);
    }
}
