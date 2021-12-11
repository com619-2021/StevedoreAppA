package uk.ac.solent.devops.impl.dao.request.spring;

import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.request.springdata.OrderChangeRequestRepository;
import uk.ac.solent.devops.model.request.dao.OrderChangeRequestDAO;
import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;

import java.util.List;
import java.util.UUID;

@Component
public class OrderChangeRequestDAOImplSpring implements OrderChangeRequestDAO {

    private final OrderChangeRequestRepository orderChangeRequestRepository;

    public OrderChangeRequestDAOImplSpring(OrderChangeRequestRepository orderChangeRequestRepository) {
        this.orderChangeRequestRepository = orderChangeRequestRepository;
    }

    @Override
    public OrderChangeRequest findById(Long id) {
        return orderChangeRequestRepository.findById(id).orElse(null);
    }

    @Override
    public OrderChangeRequest save(OrderChangeRequest orderChangeRequest) {
        return orderChangeRequestRepository.save(orderChangeRequest);
    }

    @Override
    public List<OrderChangeRequest> findAll() {
        return orderChangeRequestRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        orderChangeRequestRepository.deleteById(id);
    }

    @Override
    public void delete(OrderChangeRequest orderChangeRequest) {
        orderChangeRequestRepository.delete(orderChangeRequest);
    }

    @Override
    public void deleteAll() {
        orderChangeRequestRepository.deleteAll();
    }

    @Override
    public OrderChangeRequest findByRoleUuid(UUID uuid) {
        return orderChangeRequestRepository.findAll().stream().filter(x -> x.getUuid().equals(uuid)).findFirst().orElse(null);
    }
}
