package uk.ac.solent.devops.model.party.dto;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import uk.ac.solent.devops.model.user.dto.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class PartyMapperImpl implements PartyMapper {

    @Override
    public Party partyToParty(Party partyEntity) {
        if ( partyEntity == null ) {
            return null;
        }

        Party party = new Party();

        if ( partyEntity.getId() != null ) {
            party.setId( partyEntity.getId() );
        }
        if ( partyEntity.getFirstName() != null ) {
            party.setFirstName( partyEntity.getFirstName() );
        }
        if ( partyEntity.getSecondName() != null ) {
            party.setSecondName( partyEntity.getSecondName() );
        }
        if ( partyEntity.getPartyRole() != null ) {
            party.setPartyRole( partyEntity.getPartyRole() );
        }
        if ( partyEntity.getAddress() != null ) {
            party.setAddress( partyEntity.getAddress() );
        }
        if ( partyEntity.getPartyStatus() != null ) {
            party.setPartyStatus( partyEntity.getPartyStatus() );
        }
        if ( partyEntity.getUuid() != null ) {
            party.setUuid( partyEntity.getUuid() );
        }
        if ( partyEntity.getEnabled() != null ) {
            party.setEnabled( partyEntity.getEnabled() );
        }
        Set<User> set = partyEntity.getUsers();
        if ( set != null ) {
            party.setUsers( new HashSet<User>( set ) );
        }
        if ( partyEntity.getHref() != null ) {
            party.setHref( partyEntity.getHref() );
        }

        return party;
    }

    @Override
    public Party partyUpdatePartyEntity(Party party, Party partyEntity) {
        if ( party == null ) {
            return null;
        }

        if ( party.getId() != null ) {
            partyEntity.setId( party.getId() );
        }
        if ( party.getFirstName() != null ) {
            partyEntity.setFirstName( party.getFirstName() );
        }
        if ( party.getSecondName() != null ) {
            partyEntity.setSecondName( party.getSecondName() );
        }
        if ( party.getPartyRole() != null ) {
            partyEntity.setPartyRole( party.getPartyRole() );
        }
        if ( party.getAddress() != null ) {
            partyEntity.setAddress( party.getAddress() );
        }
        if ( party.getPartyStatus() != null ) {
            partyEntity.setPartyStatus( party.getPartyStatus() );
        }
        if ( party.getUuid() != null ) {
            partyEntity.setUuid( party.getUuid() );
        }
        if ( party.getEnabled() != null ) {
            partyEntity.setEnabled( party.getEnabled() );
        }
        if ( partyEntity.getUsers() != null ) {
            Set<User> set = party.getUsers();
            if ( set != null ) {
                partyEntity.getUsers().clear();
                partyEntity.getUsers().addAll( set );
            }
        }
        else {
            Set<User> set = party.getUsers();
            if ( set != null ) {
                partyEntity.setUsers( new HashSet<User>( set ) );
            }
        }
        if ( party.getHref() != null ) {
            partyEntity.setHref( party.getHref() );
        }

        return partyEntity;
    }

    @Override
    public PartyHref partyToHref(Party partyEntity) {
        if ( partyEntity == null ) {
            return null;
        }

        PartyHref partyHref = new PartyHref();

        if ( partyEntity.getFirstName() != null ) {
            partyHref.setName( partyEntity.getFirstName() );
        }
        if ( partyEntity.getHref() != null ) {
            partyHref.setHref( partyEntity.getHref() );
        }
        if ( partyEntity.getUuid() != null ) {
            partyHref.setUuid( partyEntity.getUuid() );
        }
        if ( partyEntity.getId() != null ) {
            partyHref.setId( partyEntity.getId() );
        }

        return partyHref;
    }
}
