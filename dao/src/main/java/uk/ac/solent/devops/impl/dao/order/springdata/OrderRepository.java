package uk.ac.solent.devops.impl.dao.order.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.solent.devops.model.order.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}