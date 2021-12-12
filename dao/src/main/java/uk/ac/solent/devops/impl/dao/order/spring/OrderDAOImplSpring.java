package uk.ac.solent.devops.impl.dao.order.spring;

import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.order.springdata.OrderRepository;
import uk.ac.solent.devops.model.order.dao.OrderDAO;
import uk.ac.solent.devops.model.order.dto.Order;

import java.util.List;
import java.util.UUID;

@Component
public class OrderDAOImplSpring implements OrderDAO {
    private final OrderRepository orderRepository;

    public OrderDAOImplSpring(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Override
    public Order findByRoleUuid(UUID uuid) {
        return orderRepository.findAll().stream().filter(x -> x.getUuid().equals(uuid)).findFirst().orElse(null);
    }
}
