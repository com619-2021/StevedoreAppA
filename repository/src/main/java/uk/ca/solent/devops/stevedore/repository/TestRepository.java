package uk.ca.solent.devops.stevedore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.ca.solent.devops.stevedore.model.TestModel;

@Repository
public interface TestRepository extends CrudRepository<TestModel, Long> {
}
