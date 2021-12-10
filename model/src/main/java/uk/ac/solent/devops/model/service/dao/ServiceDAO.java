package uk.ac.solent.devops.model.service.dao;

import uk.ac.solent.devops.model.service.dto.Service;
import uk.ac.solent.devops.model.user.dto.Role;

import java.util.List;
import java.util.UUID;

public interface ServiceDAO {

    Service findById(Long id);

    Service save(Role role);

    List<Service> findAll();

    void deleteById(long id);

    void delete(Service role);

    void deleteAll();

    Service findByRoleUuid(UUID uuid);

}
