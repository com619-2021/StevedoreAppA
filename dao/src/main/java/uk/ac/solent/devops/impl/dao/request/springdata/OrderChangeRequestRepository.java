package uk.ac.solent.devops.impl.dao.request.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.solent.devops.model.request.dto.OrderChangeRequest;

public interface OrderChangeRequestRepository extends JpaRepository<OrderChangeRequest, Long> {
}
