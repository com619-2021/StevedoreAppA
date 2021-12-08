package uk.ac.solent.devops.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.ac.solent.devops.model.party.dao.PartyDAO;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;
import uk.ac.solent.devops.model.service.ServiceFacade;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// note we give the bean this name so it is picked up later in application context
@Component("serviceFacade")
public class ServiceFacadeImpl implements ServiceFacade {

    @Autowired
    private PartyDAO partyDao = null;

    // used to concurently count heartbeat requests
    private static AtomicInteger heartbeatRequests = new AtomicInteger();

    // setters for DAOs
    public void setPartyDao(PartyDAO partyDao) {
        this.partyDao = partyDao;
    }

    // Service facade methods
    @Override
    public String getHeartbeat() {
        return "heartbeat number " + heartbeatRequests.getAndIncrement() + " " + new Date().toString();

    }

    @Override
    public List<Party> findByPartyRole(PartyRole partyRole) {
        if (partyRole == null) {
            return partyDao.findAll();
        } else {
            return partyDao.findByPartyRole(partyRole);
        }
    }

}
