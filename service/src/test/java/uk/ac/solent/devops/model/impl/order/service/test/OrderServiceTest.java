/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.impl.order.service.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.impl.service.test.ServiceTestConfiguration;
import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.order.dto.OrderStatus;
import uk.ac.solent.devops.model.order.service.OrderService;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyRole;
import uk.ac.solent.devops.model.party.service.PartyService;
import uk.ac.solent.devops.model.resource.dto.Characteristic;
import uk.ac.solent.devops.model.resource.dto.Resource;
import uk.ac.solent.devops.model.resource.dto.ResourceAccess;
import uk.ac.solent.devops.model.resource.service.ResourceCatalogService;
import uk.ac.solent.devops.model.resource.service.ResourceInventoryService;
import uk.ac.solent.devops.model.service.ServiceFacade;
import uk.ac.solent.devops.model.utilities.PrintOutJson;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author gallenc
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes = ServiceTestConfiguration.class, loader = AnnotationConfigContextLoader.class)
@Transactional
public class OrderServiceTest {

    final static Logger LOG = LogManager.getLogger(OrderServiceTest.class);

    @Autowired
    ServiceFacade serviceFacade = null;

    @Autowired
    ResourceCatalogService resourceCatalogService = null;

    @Autowired
    ResourceInventoryService resourceInventoryService = null;

    @Autowired
    PartyService partyService = null;

    @Autowired
    OrderService orderService = null;

    public void testFactory() {
        LOG.debug("start OrderServiceTest testFactory");
        assertNotNull(serviceFacade);
        assertNotNull(resourceInventoryService);
        assertNotNull(partyService);
        assertNotNull(orderService);
        LOG.debug("end OrderServiceTest testFactory");
    }

    @Test
    public void internalOrderTest() {
        // create a resource with a party
        Party party1 = new Party();
        party1.setFirstName("party1");
        party1.setPartyRole(PartyRole.SELLER);
        party1 = partyService.save(party1);
        LOG.debug("party1=" + party1);

        Resource resourceIn = mockResource();
        String ownerPartyUUID = party1.getUuid();

        ReplyMessage replyMessage = resourceInventoryService.postCreateResource(resourceIn, ownerPartyUUID);
        List<Resource> resourceList = replyMessage.getResourceList();
        assertEquals(1, resourceList.size());

        Resource createdResource = resourceList.get(0);
        LOG.debug("created Resource:" + createdResource);

        Order order = new Order();
        order.setDescription("order description");
        order.setName("PO1234");
        order.setEndDate(new Date());
        order.setOrderDate(new Date());

        order.setStartDate(new Date());
        order.setStatus(OrderStatus.ACKNOWLEGED);
        String testUUID = UUID.randomUUID().toString();
        order.setUuid(testUUID);
        order.setHref("http://orderhref/" + order.getUuid());

        replyMessage = orderService.postCreateOrder(order, party1.getUuid());

        String jsonOut = PrintOutJson.getJson(replyMessage);

        LOG.debug("reply message " + jsonOut);

    }

    /*
    TOTO REMOVE WHEN NOT NEEDED
     */
    private Resource mockResource() {
        Resource resource = new Resource();
        List<Characteristic> characteristics = new ArrayList();
        characteristics.add(new Characteristic("characteristicName1", "characteristic value1", "characteristic description1"));
        characteristics.add(new Characteristic("characteristicName2", "characteristic value2", "characteristic description2"));
        resource.setCharacteristics(characteristics);
        String description = "temp description";
        resource.setDescription(description);
        String href = "http://temp";
        resource.setHref(href);
        //  resource.setId(1L);
        String name = "resource name";
        resource.setName(name);
        resource.setResourceController(ResourceAccess.EXTERNAL);
        String resourceTypeName = "recource type name";
        resource.setResourceTypeName(resourceTypeName);
        resource.setUuid(UUID.randomUUID().toString());
        return resource;
    }
}
