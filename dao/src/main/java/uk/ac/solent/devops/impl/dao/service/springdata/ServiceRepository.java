package uk.ac.solent.devops.impl.dao.service.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.solent.devops.model.service.dto.ServiceModel;

public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
