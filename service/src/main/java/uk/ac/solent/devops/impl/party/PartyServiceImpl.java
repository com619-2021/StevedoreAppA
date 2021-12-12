package uk.ac.solent.devops.impl.party;

import org.springframework.stereotype.Service;
import uk.ac.solent.devops.impl.dao.party.springdata.PartyRepository;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.service.PartyService;

import java.util.List;
import java.util.UUID;

@Service
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;

    public PartyServiceImpl(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Party create(Party user) {
        return null;
    }

    @Override
    public Party findByUuid(UUID uuid) {
        return null;
    }

    @Override
    public List<Party> findAll() {
        return null;
    }

    @Override
    public Party save(Party user) {
        return null;
    }
}
