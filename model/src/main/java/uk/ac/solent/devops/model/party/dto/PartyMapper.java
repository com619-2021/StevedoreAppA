/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.party.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author cgallen
 */
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PartyMapper {

    PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);

    /**
     * Creates new party object decoupled from partyEntity
     *
     * @param party
     * @return
     */
    Party partyToParty(Party partyEntity);

    Party partyUpdatePartyEntity(Party party, @MappingTarget Party partyEntity);

    @Mapping(source = "firstName", target = "name")
    PartyHref partyToHref(Party partyEntity);
    
}
