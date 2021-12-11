package uk.ac.solent.devops.impl.dao.party.spring;

import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.party.springdata.PartyRepository;
import uk.ac.solent.devops.model.party.dao.PartyDAO;
import uk.ac.solent.devops.model.party.dto.Party;

import java.util.List;
import java.util.UUID;

@Component
public class PartyDAOImplSpring implements PartyDAO {

    private final PartyRepository partyRepository;

    public PartyDAOImplSpring(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Party findById(Long id) {
        return partyRepository.findById(id).orElse(null);
    }

    @Override
    public Party save(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public List<Party> findAll() {
        return partyRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        partyRepository.deleteById(id);
    }

    @Override
    public void delete(Party party) {
        partyRepository.delete(party);
    }

    @Override
    public void deleteAll() {
        partyRepository.deleteAll();
    }

    @Override
    public Party findByRoleUuid(UUID uuid) {
        return partyRepository.findAll().stream().filter(x -> x.getUuid().equals(uuid)).findFirst().orElse(null);
    }
}
