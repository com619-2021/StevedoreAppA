package uk.ac.solent.devops.model.request.dao;

import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;

import java.util.List;
import java.util.UUID;

public interface OrderChangeRequestDAO {

    OrderChangeRequest findById(Long id);

    OrderChangeRequest save(OrderChangeRequest orderChangeRequest);

    List<OrderChangeRequest> findAll();

    void deleteById(long id);

    void delete(OrderChangeRequest orderChangeRequest);

    void deleteAll();

    OrderChangeRequest findByRoleUuid(UUID uuid);

}
