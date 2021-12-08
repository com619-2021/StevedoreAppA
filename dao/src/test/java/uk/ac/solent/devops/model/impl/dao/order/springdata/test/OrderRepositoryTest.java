/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.impl.dao.order.springdata.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import uk.ac.solent.devops.impl.dao.order.springdata.OrderChangeRequestRepository;
import uk.ac.solent.devops.impl.dao.order.springdata.OrderRepository;
import uk.ac.solent.devops.impl.dao.party.springdata.PartyRepository;
import uk.ac.solent.devops.impl.dao.resource.springdata.ResourceCatalogRepository;
import uk.ac.solent.devops.impl.dao.resource.springdata.ResourceRepository;
import uk.ac.solent.devops.model.impl.dao.spring.test.DAOTestConfiguration;
import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.order.dto.OrderEntity;
import uk.ac.solent.devops.model.order.dto.OrderMapper;
import uk.ac.solent.devops.model.order.dto.OrderStatus;
import uk.ac.solent.devops.model.utilities.PrintOutJson;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author cgallen
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the DAOTestConfiguration class
@ContextConfiguration(classes = DAOTestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class OrderRepositoryTest {

    final static Logger LOG = LogManager.getLogger(OrderRepositoryTest.class);

    @Autowired
    private PartyRepository partyRepository = null;

    @Autowired
    private ResourceRepository resourceRepository = null;

    @Autowired
    private ResourceCatalogRepository resourceCatalogRepository = null;

    @Autowired
    private OrderRepository orderRepository = null;

    @Autowired
    private OrderChangeRequestRepository orderChangeRequestRepository = null;

    @Before
    public void before() {
        LOG.debug("before test running");
        assertNotNull(partyRepository);
        assertNotNull(resourceRepository);
        assertNotNull(resourceCatalogRepository);
        assertNotNull(orderChangeRequestRepository);
        assertNotNull(orderRepository);
        LOG.debug("before test complete");
    }

    @Transactional
    @Test
    public void loadRepositoryTest() {
        // just tests load
        LOG.debug("*** start of loadRepositoryTest");
        LOG.debug("*** end of loadRepositoryTest");
    }

    @Transactional
    @Test
    public void resourceOrderRepositoryTest() {
        LOG.debug("*** start of resourceRepositoryTest");

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

        OrderEntity orderEntity = new OrderEntity();

        orderEntity = orderRepository.save(orderEntity);
        LOG.debug("*** test orderEntity 1 = " + orderEntity);

        orderEntity = OrderMapper.INSTANCE.updateOrderEntity(order, orderEntity);
        orderEntity = orderRepository.save(orderEntity);
        LOG.debug("*** test savedOrderEntity 1 = " + orderEntity);

        List<OrderEntity> foundOrderEntityList = orderRepository.findByUuid(testUUID);
        assertEquals(1, foundOrderEntityList.size());

        OrderEntity foundOrderEntity = foundOrderEntityList.get(0);
        LOG.debug("*** test foundOrderEntity 1 = " + foundOrderEntity);

        Order foundOrder = OrderMapper.INSTANCE.orderEntityToOrder(foundOrderEntity);
        LOG.debug("*** test foundOrder 1 = " + foundOrder);

        LOG.debug("*** end of resourceRepositoryTest");
    }

    @Transactional
    @Test
    public void resourceParentOrderRepositoryTest() {
        LOG.debug("*** start of resourceParentOrderRepositoryTest");

        // create 3 order entities
        // order entity 1
        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setDescription("order description");
        orderEntity1.setName("orderEntity1");
        orderEntity1.setEndDate(new Date());
        orderEntity1.setOrderDate(new Date());

        orderEntity1.setStartDate(new Date());
        orderEntity1.setStatus(OrderStatus.ACKNOWLEGED);
        String testUUID = UUID.randomUUID().toString();
        orderEntity1.setUuid(testUUID);
        orderEntity1.setHref("http://orderhref/" + orderEntity1.getUuid());

        orderEntity1 = orderRepository.save(orderEntity1);
        LOG.debug("*** test savedOrderEntity1 A = " + orderEntity1);

        // order entity 2
        OrderEntity orderEntity2 = new OrderEntity();
        orderEntity2.setDescription("order description");
        orderEntity2.setName("orderEntity2");
        orderEntity2.setEndDate(new Date());
        orderEntity2.setOrderDate(new Date());

        orderEntity2.setStartDate(new Date());
        orderEntity2.setStatus(OrderStatus.ACKNOWLEGED);
        String testUUID2 = UUID.randomUUID().toString();
        orderEntity2.setUuid(testUUID2);
        orderEntity2.setHref("http://orderhref/" + orderEntity2.getUuid());

        orderEntity2 = orderRepository.save(orderEntity2);
        LOG.debug("*** test savedOrderEntity2 B = " + orderEntity2);

        // order entity 3
        OrderEntity orderEntity3 = new OrderEntity();
        orderEntity3.setDescription("order description");
        orderEntity3.setName("orderEntity3");
        orderEntity3.setEndDate(new Date());
        orderEntity3.setOrderDate(new Date());

        orderEntity3.setStartDate(new Date());
        orderEntity3.setStatus(OrderStatus.ACKNOWLEGED);
        String testUUID3 = UUID.randomUUID().toString();
        orderEntity3.setUuid(testUUID3);
        orderEntity3.setHref("http://orderhref/" + orderEntity3.getUuid());

        orderEntity3 = orderRepository.save(orderEntity3);
        LOG.debug("*** test orderEntity3 C = " + orderEntity3);
        
        List<OrderEntity> elements = orderRepository.findAll();
        assertEquals(3,elements.size());

        orderEntity2.setParentOrder(orderEntity1);
        orderEntity2 = orderRepository.saveAndFlush(orderEntity2);
        LOG.debug("*** test orderEntity2 D = " + orderEntity2);

        // note this doesnt work - some problem with immutable arrays
        //List subOrders = Arrays.asList(orderEntity3);
        //orderEntity2.setSubOrders(subOrders);
        
        // this works - but also need array list created empty
        List<OrderEntity> subOrders = orderEntity2.getSubOrders();
        subOrders.add(orderEntity3);
        orderEntity2.setSubOrders(subOrders);
                
        orderEntity2 = orderRepository.save(orderEntity2);
        LOG.debug("*** test orderEntity2 E = " + orderEntity2);

        List<OrderEntity> foundOrderEntitys = orderRepository.findByUuid(testUUID2);
        assertEquals(1,foundOrderEntitys.size());
        
        OrderEntity foundOrderEntity = foundOrderEntitys.get(0);
        
        
        Order foundOrder = OrderMapper.INSTANCE.orderEntityToOrder(foundOrderEntity);

        LOG.debug("*** test returned order object = " + PrintOutJson.getJson(foundOrder));

        LOG.debug("*** end of resourceParentOrderRepositoryTest");
    }

}
