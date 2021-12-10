package uk.ac.solent.devops.model.order.dao;

import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.user.dto.Role;

import java.util.List;
import java.util.UUID;

public interface OrderDAO {

    Order findById(Long id);

    Order save(Role role);

    List<Order> findAll();

    void deleteById(long id);

    void delete(Order role);

    void deleteAll();

    Order findByRoleUuid(UUID uuid);

}
