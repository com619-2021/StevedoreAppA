package uk.ac.solent.devops.model.service;

import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;

import java.util.List;

public interface ServiceFacade {

    public String getHeartbeat();

    /**
     * find all partys in database by partyRole if partyRole is null return all partys
     *
     * @param partyRole
     * @return list of party objects
     */
    public List<Party> findByPartyRole(PartyRole partyRole);

}
