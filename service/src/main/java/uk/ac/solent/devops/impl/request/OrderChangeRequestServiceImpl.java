package uk.ac.solent.devops.impl.request;

import org.springframework.stereotype.Service;
import uk.ac.solent.devops.impl.dao.request.springdata.OrderChangeRequestRepository;
import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;
import uk.ac.solent.devops.model.request.service.OrderChangeRequestService;

import java.util.List;
import java.util.UUID;

@Service
public class OrderChangeRequestServiceImpl implements OrderChangeRequestService {

    private final OrderChangeRequestRepository orderChangeRequestRepository;

    public OrderChangeRequestServiceImpl(OrderChangeRequestRepository orderChangeRequestRepository) {
        this.orderChangeRequestRepository = orderChangeRequestRepository;
    }

    @Override
    public OrderChangeRequest create(OrderChangeRequest user) {
        return null;
    }

    @Override
    public OrderChangeRequest findByUuid(UUID uuid) {
        return null;
    }

    @Override
    public List<OrderChangeRequest> findAll() {
        return null;
    }

    @Override
    public OrderChangeRequest save(OrderChangeRequest user) {
        return null;
    }
}
