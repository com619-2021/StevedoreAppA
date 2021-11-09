package uk.ca.solent.devops.stevedore.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ca.solent.devops.stevedore.model.order.OrderModel;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderModel, Long> {
}
