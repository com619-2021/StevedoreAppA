package uk.ac.solent.devops.model.service.dao;

import uk.ac.solent.devops.model.service.dto.ServiceModel;

import java.util.List;
import java.util.UUID;

public interface ServiceModelDAO {

    ServiceModel findById(Long id);

    ServiceModel save(ServiceModel service);

    List<ServiceModel> findAll();

    void deleteById(long id);

    void delete(ServiceModel service);

    void deleteAll();

    ServiceModel findByRoleUuid(UUID uuid);

}
