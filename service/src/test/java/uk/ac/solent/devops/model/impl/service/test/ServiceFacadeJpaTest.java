/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.impl.service.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;
import uk.ac.solent.devops.model.service.ServiceFacade;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author gallenc
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes = ServiceTestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class ServiceFacadeJpaTest {

    final static Logger LOG = LogManager.getLogger(ServiceFacadeJpaTest.class);

    @Autowired
    ServiceFacade serviceFacade = null;

    @Test
    public void testFactory() {
        LOG.debug("start ServiceFacadeTest testFpartyy");
        assertNotNull(serviceFacade);
        LOG.debug("end ServiceFacadeTest testFpartyy");
    }

    @Test
    public void testGetHeartbeat() {
        LOG.debug("start ServiceFacadeTest testGetHeartbeat()");
        assertNotNull(serviceFacade);

        String heartbeat = serviceFacade.getHeartbeat();
        LOG.debug("recieved heartbeat: " + heartbeat);
        assertNotNull(heartbeat);

        LOG.debug("end FarmFacadeTest testGetHeartbeat()");
    }

    @Test
    public void testGetAllByPartyRole() {

        // you may want to create people first but you need to add this to the facade :)
        List<Party> partyList = serviceFacade.findByPartyRole(null);
        assertNotNull(partyList);

        partyList = serviceFacade.findByPartyRole(PartyRole.UNDEFINED);
        assertNotNull(partyList);

    }

    // WHAT OTHER TESTS DO YOU NEED FOR THE SERVICE?
}
