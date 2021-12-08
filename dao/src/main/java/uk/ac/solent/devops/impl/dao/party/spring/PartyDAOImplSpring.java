/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.dao.party.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.ac.solent.devops.impl.dao.party.springdata.PartyRepository;
import uk.ac.solent.devops.model.party.dao.PartyDAO;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;

import java.util.List;


/**
 *
 * @author gallenc
 */
@Component
public class PartyDAOImplSpring implements PartyDAO {
    
    @Autowired
    private PartyRepository partyRepository = null;

    @Override
    public Party findById(Long id) {
        return partyRepository.getOne(id);
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
    public List<Party> findByPartyRole(PartyRole partyRole) {
        return partyRepository.findByPartyRole(partyRole);
    }

    @Override
    public List<Party> findByName(String firstName, String secondName) {
        return partyRepository.findByName(firstName, secondName);
    }

    @Override
    public Party findByUuid(String uuid) {
        List<Party> parties = partyRepository.findByUuid(uuid);
        if (parties.isEmpty()) return null;
        return parties.get(0);
    }
    
    
}
