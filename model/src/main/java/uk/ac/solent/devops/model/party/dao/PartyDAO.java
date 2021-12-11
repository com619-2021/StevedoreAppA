package uk.ac.solent.devops.model.party.dao;

import uk.ac.solent.devops.model.party.dto.Party;

import java.util.List;
import java.util.UUID;

public interface PartyDAO {

    Party findById(Long id);

    Party save(Party party);

    List<Party> findAll();

    void deleteById(long id);

    void delete(Party party);

    void deleteAll();

    Party findByRoleUuid(UUID uuid);

}
