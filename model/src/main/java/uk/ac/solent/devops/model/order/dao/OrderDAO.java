package uk.ac.solent.devops.model.order.dao;

import uk.ac.solent.devops.model.order.dto.Order;

import java.util.List;
import java.util.UUID;

public interface OrderDAO {

    Order findById(Long id);

    Order save(Order order);

    List<Order> findAll();

    void deleteById(long id);

    void delete(Order order);

    void deleteAll();

    Order findByRoleUuid(UUID uuid);

}
