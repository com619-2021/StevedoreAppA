package uk.ca.solent.devops.stevedore.repository.ros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ca.solent.devops.stevedore.model.ros.ResourceOrServiceModel;

@Repository
public interface ResourceOrServiceRepository extends JpaRepository<ResourceOrServiceModel, Long> {

}
