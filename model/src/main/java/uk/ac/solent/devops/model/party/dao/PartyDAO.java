package uk.ac.solent.devops.model.party.dao;

import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.user.dto.Role;

import java.util.List;
import java.util.UUID;

public interface PartyDAO {

    Party findById(Long id);

    Party save(Role role);

    List<Party> findAll();

    void deleteById(long id);

    void delete(Party role);

    void deleteAll();

    Party findByRoleUuid(UUID uuid);

}
