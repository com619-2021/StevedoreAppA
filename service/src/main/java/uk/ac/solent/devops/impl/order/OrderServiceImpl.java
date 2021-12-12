package uk.ac.solent.devops.impl.order;

import org.springframework.stereotype.Service;
import uk.ac.solent.devops.impl.dao.order.springdata.OrderRepository;
import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.order.service.OrderService;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order user) {
        return null;
    }

    @Override
    public Order findByUuid(UUID uuid) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order save(Order user) {
        return null;
    }
}
