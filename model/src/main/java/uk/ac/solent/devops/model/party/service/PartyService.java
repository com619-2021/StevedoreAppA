/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.party.service;

import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;

import java.util.List;

/**
 *
 * @author cgallen
 */
public interface PartyService {

    public Party findById(Long id);

    public Party save(Party party);

    public List<Party> findAll();

    public void deleteById(long id);

    public void delete(Party party);

    public void deleteAll();

    public List<Party> findByPartyRole(PartyRole partyRole);

    public List<Party> findByName(String firstName, String secondName);
    
    public Party findByUuid(String uuid);
    
    public List<PartyRole> getAvailablePartyRoles();
    
}
