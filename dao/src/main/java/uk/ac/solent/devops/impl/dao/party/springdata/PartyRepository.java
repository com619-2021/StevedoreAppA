package uk.ac.solent.devops.impl.dao.party.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.solent.devops.model.party.dto.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
