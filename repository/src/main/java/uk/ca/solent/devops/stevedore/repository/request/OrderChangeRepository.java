package uk.ca.solent.devops.stevedore.repository.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ca.solent.devops.stevedore.model.request.OrderChangeRequestModel;

@Repository
public interface OrderChangeRepository extends JpaRepository<OrderChangeRequestModel, Long> {
}
