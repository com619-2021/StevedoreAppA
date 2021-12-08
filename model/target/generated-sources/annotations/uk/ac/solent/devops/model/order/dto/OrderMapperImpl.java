package uk.ac.solent.devops.model.order.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyHref;
import uk.ac.solent.devops.model.resource.dto.Resource;
import uk.ac.solent.devops.model.resource.dto.ResourceHref;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity orderToOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        if ( order.getId() != null ) {
            orderEntity.setId( order.getId() );
        }
        if ( order.getHref() != null ) {
            orderEntity.setHref( order.getHref() );
        }
        if ( order.getUuid() != null ) {
            orderEntity.setUuid( order.getUuid() );
        }
        if ( order.getName() != null ) {
            orderEntity.setName( order.getName() );
        }
        List<OrderEntity> list = orderHrefListToOrderEntityList( order.getSubOrders() );
        if ( list != null ) {
            orderEntity.setSubOrders( list );
        }
        if ( order.getDescription() != null ) {
            orderEntity.setDescription( order.getDescription() );
        }
        if ( order.getOrderDate() != null ) {
            orderEntity.setOrderDate( order.getOrderDate() );
        }
        if ( order.getStartDate() != null ) {
            orderEntity.setStartDate( order.getStartDate() );
        }
        if ( order.getEndDate() != null ) {
            orderEntity.setEndDate( order.getEndDate() );
        }
        if ( order.getOrderOwner() != null ) {
            orderEntity.setOrderOwner( partyHrefToParty( order.getOrderOwner() ) );
        }
        List<OrderChangeRequestEntity> list1 = orderChangeRequestHrefListToOrderChangeRequestEntityList( order.getChangeRequests() );
        if ( list1 != null ) {
            orderEntity.setChangeRequests( list1 );
        }
        if ( order.getParentOrder() != null ) {
            orderEntity.setParentOrder( orderHrefToOrderEntity( order.getParentOrder() ) );
        }
        List<Resource> list2 = resourceHrefListToResourceList( order.getResourceOrService() );
        if ( list2 != null ) {
            orderEntity.setResourceOrService( list2 );
        }
        if ( order.getStatus() != null ) {
            orderEntity.setStatus( order.getStatus() );
        }
        if ( order.getResourceAccess() != null ) {
            orderEntity.setResourceAccess( order.getResourceAccess() );
        }

        return orderEntity;
    }

    @Override
    public Order orderEntityToOrder(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        if ( orderEntity.getId() != null ) {
            order.setId( orderEntity.getId() );
        }
        if ( orderEntity.getHref() != null ) {
            order.setHref( orderEntity.getHref() );
        }
        if ( orderEntity.getUuid() != null ) {
            order.setUuid( orderEntity.getUuid() );
        }
        if ( orderEntity.getName() != null ) {
            order.setName( orderEntity.getName() );
        }
        List<OrderHref> list = orderEntityListToOrderHrefList( orderEntity.getSubOrders() );
        if ( list != null ) {
            order.setSubOrders( list );
        }
        if ( orderEntity.getDescription() != null ) {
            order.setDescription( orderEntity.getDescription() );
        }
        if ( orderEntity.getOrderDate() != null ) {
            order.setOrderDate( orderEntity.getOrderDate() );
        }
        if ( orderEntity.getStartDate() != null ) {
            order.setStartDate( orderEntity.getStartDate() );
        }
        if ( orderEntity.getEndDate() != null ) {
            order.setEndDate( orderEntity.getEndDate() );
        }
        if ( orderEntity.getOrderOwner() != null ) {
            order.setOrderOwner( partyToHref( orderEntity.getOrderOwner() ) );
        }
        List<OrderChangeRequestHref> list1 = orderChangeRequestEntityListToOrderChangeRequestHrefList( orderEntity.getChangeRequests() );
        if ( list1 != null ) {
            order.setChangeRequests( list1 );
        }
        if ( orderEntity.getParentOrder() != null ) {
            order.setParentOrder( orderEntityToOrderHref( orderEntity.getParentOrder() ) );
        }
        List<ResourceHref> list2 = resourceListToResourceHrefList( orderEntity.getResourceOrService() );
        if ( list2 != null ) {
            order.setResourceOrService( list2 );
        }
        if ( orderEntity.getStatus() != null ) {
            order.setStatus( orderEntity.getStatus() );
        }
        if ( orderEntity.getResourceAccess() != null ) {
            order.setResourceAccess( orderEntity.getResourceAccess() );
        }

        return order;
    }

    @Override
    public OrderHref orderToOrderHref(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderHref orderHref = new OrderHref();

        if ( order.getHref() != null ) {
            orderHref.setHref( order.getHref() );
        }
        if ( order.getUuid() != null ) {
            orderHref.setUuid( order.getUuid() );
        }
        if ( order.getId() != null ) {
            orderHref.setId( order.getId() );
        }
        if ( order.getName() != null ) {
            orderHref.setName( order.getName() );
        }

        return orderHref;
    }

    @Override
    public OrderHref orderEntityToOrderHref(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderHref orderHref = new OrderHref();

        if ( orderEntity.getHref() != null ) {
            orderHref.setHref( orderEntity.getHref() );
        }
        if ( orderEntity.getUuid() != null ) {
            orderHref.setUuid( orderEntity.getUuid() );
        }
        if ( orderEntity.getId() != null ) {
            orderHref.setId( orderEntity.getId() );
        }
        if ( orderEntity.getName() != null ) {
            orderHref.setName( orderEntity.getName() );
        }

        return orderHref;
    }

    @Override
    public OrderEntity updateOrderEntity(Order order, OrderEntity orderEntity) {
        if ( order == null ) {
            return null;
        }

        if ( order.getId() != null ) {
            orderEntity.setId( order.getId() );
        }
        if ( order.getHref() != null ) {
            orderEntity.setHref( order.getHref() );
        }
        if ( order.getUuid() != null ) {
            orderEntity.setUuid( order.getUuid() );
        }
        if ( order.getName() != null ) {
            orderEntity.setName( order.getName() );
        }
        if ( orderEntity.getSubOrders() != null ) {
            List<OrderEntity> list = orderHrefListToOrderEntityList( order.getSubOrders() );
            if ( list != null ) {
                orderEntity.getSubOrders().clear();
                orderEntity.getSubOrders().addAll( list );
            }
        }
        else {
            List<OrderEntity> list = orderHrefListToOrderEntityList( order.getSubOrders() );
            if ( list != null ) {
                orderEntity.setSubOrders( list );
            }
        }
        if ( order.getDescription() != null ) {
            orderEntity.setDescription( order.getDescription() );
        }
        if ( order.getOrderDate() != null ) {
            orderEntity.setOrderDate( order.getOrderDate() );
        }
        if ( order.getStartDate() != null ) {
            orderEntity.setStartDate( order.getStartDate() );
        }
        if ( order.getEndDate() != null ) {
            orderEntity.setEndDate( order.getEndDate() );
        }
        if ( order.getOrderOwner() != null ) {
            if ( orderEntity.getOrderOwner() == null ) {
                orderEntity.setOrderOwner( new Party() );
            }
            partyHrefToParty1( order.getOrderOwner(), orderEntity.getOrderOwner() );
        }
        if ( orderEntity.getChangeRequests() != null ) {
            List<OrderChangeRequestEntity> list1 = orderChangeRequestHrefListToOrderChangeRequestEntityList( order.getChangeRequests() );
            if ( list1 != null ) {
                orderEntity.getChangeRequests().clear();
                orderEntity.getChangeRequests().addAll( list1 );
            }
        }
        else {
            List<OrderChangeRequestEntity> list1 = orderChangeRequestHrefListToOrderChangeRequestEntityList( order.getChangeRequests() );
            if ( list1 != null ) {
                orderEntity.setChangeRequests( list1 );
            }
        }
        if ( order.getParentOrder() != null ) {
            if ( orderEntity.getParentOrder() == null ) {
                orderEntity.setParentOrder( new OrderEntity() );
            }
            orderHrefToOrderEntity1( order.getParentOrder(), orderEntity.getParentOrder() );
        }
        if ( orderEntity.getResourceOrService() != null ) {
            List<Resource> list2 = resourceHrefListToResourceList( order.getResourceOrService() );
            if ( list2 != null ) {
                orderEntity.getResourceOrService().clear();
                orderEntity.getResourceOrService().addAll( list2 );
            }
        }
        else {
            List<Resource> list2 = resourceHrefListToResourceList( order.getResourceOrService() );
            if ( list2 != null ) {
                orderEntity.setResourceOrService( list2 );
            }
        }
        if ( order.getStatus() != null ) {
            orderEntity.setStatus( order.getStatus() );
        }
        if ( order.getResourceAccess() != null ) {
            orderEntity.setResourceAccess( order.getResourceAccess() );
        }

        return orderEntity;
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

    protected OrderEntity orderHrefToOrderEntity(OrderHref orderHref) {
        if ( orderHref == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        if ( orderHref.getId() != null ) {
            orderEntity.setId( orderHref.getId() );
        }
        if ( orderHref.getHref() != null ) {
            orderEntity.setHref( orderHref.getHref() );
        }
        if ( orderHref.getUuid() != null ) {
            orderEntity.setUuid( orderHref.getUuid() );
        }
        if ( orderHref.getName() != null ) {
            orderEntity.setName( orderHref.getName() );
        }

        return orderEntity;
    }

    protected List<OrderEntity> orderHrefListToOrderEntityList(List<OrderHref> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderEntity> list1 = new ArrayList<OrderEntity>( list.size() );
        for ( OrderHref orderHref : list ) {
            list1.add( orderHrefToOrderEntity( orderHref ) );
        }

        return list1;
    }

    protected Party partyHrefToParty(PartyHref partyHref) {
        if ( partyHref == null ) {
            return null;
        }

        Party party = new Party();

        if ( partyHref.getId() != null ) {
            party.setId( partyHref.getId() );
        }
        if ( partyHref.getUuid() != null ) {
            party.setUuid( partyHref.getUuid() );
        }
        if ( partyHref.getHref() != null ) {
            party.setHref( partyHref.getHref() );
        }

        return party;
    }

    protected OrderChangeRequestEntity orderChangeRequestHrefToOrderChangeRequestEntity(OrderChangeRequestHref orderChangeRequestHref) {
        if ( orderChangeRequestHref == null ) {
            return null;
        }

        OrderChangeRequestEntity orderChangeRequestEntity = new OrderChangeRequestEntity();

        if ( orderChangeRequestHref.getId() != null ) {
            orderChangeRequestEntity.setId( orderChangeRequestHref.getId() );
        }
        if ( orderChangeRequestHref.getRequestDate() != null ) {
            orderChangeRequestEntity.setRequestDate( orderChangeRequestHref.getRequestDate() );
        }
        if ( orderChangeRequestHref.getUuid() != null ) {
            orderChangeRequestEntity.setUuid( orderChangeRequestHref.getUuid() );
        }
        if ( orderChangeRequestHref.getHref() != null ) {
            orderChangeRequestEntity.setHref( orderChangeRequestHref.getHref() );
        }

        return orderChangeRequestEntity;
    }

    protected List<OrderChangeRequestEntity> orderChangeRequestHrefListToOrderChangeRequestEntityList(List<OrderChangeRequestHref> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderChangeRequestEntity> list1 = new ArrayList<OrderChangeRequestEntity>( list.size() );
        for ( OrderChangeRequestHref orderChangeRequestHref : list ) {
            list1.add( orderChangeRequestHrefToOrderChangeRequestEntity( orderChangeRequestHref ) );
        }

        return list1;
    }

    protected Resource resourceHrefToResource(ResourceHref resourceHref) {
        if ( resourceHref == null ) {
            return null;
        }

        Resource resource = new Resource();

        if ( resourceHref.getId() != null ) {
            resource.setId( resourceHref.getId() );
        }
        if ( resourceHref.getHref() != null ) {
            resource.setHref( resourceHref.getHref() );
        }
        if ( resourceHref.getUuid() != null ) {
            resource.setUuid( resourceHref.getUuid() );
        }
        if ( resourceHref.getName() != null ) {
            resource.setName( resourceHref.getName() );
        }

        return resource;
    }

    protected List<Resource> resourceHrefListToResourceList(List<ResourceHref> list) {
        if ( list == null ) {
            return null;
        }

        List<Resource> list1 = new ArrayList<Resource>( list.size() );
        for ( ResourceHref resourceHref : list ) {
            list1.add( resourceHrefToResource( resourceHref ) );
        }

        return list1;
    }

    protected List<OrderHref> orderEntityListToOrderHrefList(List<OrderEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderHref> list1 = new ArrayList<OrderHref>( list.size() );
        for ( OrderEntity orderEntity : list ) {
            list1.add( orderEntityToOrderHref( orderEntity ) );
        }

        return list1;
    }

    protected OrderChangeRequestHref orderChangeRequestEntityToOrderChangeRequestHref(OrderChangeRequestEntity orderChangeRequestEntity) {
        if ( orderChangeRequestEntity == null ) {
            return null;
        }

        OrderChangeRequestHref orderChangeRequestHref = new OrderChangeRequestHref();

        if ( orderChangeRequestEntity.getHref() != null ) {
            orderChangeRequestHref.setHref( orderChangeRequestEntity.getHref() );
        }
        if ( orderChangeRequestEntity.getUuid() != null ) {
            orderChangeRequestHref.setUuid( orderChangeRequestEntity.getUuid() );
        }
        if ( orderChangeRequestEntity.getId() != null ) {
            orderChangeRequestHref.setId( orderChangeRequestEntity.getId() );
        }
        if ( orderChangeRequestEntity.getRequestDate() != null ) {
            orderChangeRequestHref.setRequestDate( orderChangeRequestEntity.getRequestDate() );
        }

        return orderChangeRequestHref;
    }

    protected List<OrderChangeRequestHref> orderChangeRequestEntityListToOrderChangeRequestHrefList(List<OrderChangeRequestEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderChangeRequestHref> list1 = new ArrayList<OrderChangeRequestHref>( list.size() );
        for ( OrderChangeRequestEntity orderChangeRequestEntity : list ) {
            list1.add( orderChangeRequestEntityToOrderChangeRequestHref( orderChangeRequestEntity ) );
        }

        return list1;
    }

    protected ResourceHref resourceToResourceHref(Resource resource) {
        if ( resource == null ) {
            return null;
        }

        ResourceHref resourceHref = new ResourceHref();

        if ( resource.getHref() != null ) {
            resourceHref.setHref( resource.getHref() );
        }
        if ( resource.getUuid() != null ) {
            resourceHref.setUuid( resource.getUuid() );
        }
        if ( resource.getId() != null ) {
            resourceHref.setId( resource.getId() );
        }
        if ( resource.getName() != null ) {
            resourceHref.setName( resource.getName() );
        }

        return resourceHref;
    }

    protected List<ResourceHref> resourceListToResourceHrefList(List<Resource> list) {
        if ( list == null ) {
            return null;
        }

        List<ResourceHref> list1 = new ArrayList<ResourceHref>( list.size() );
        for ( Resource resource : list ) {
            list1.add( resourceToResourceHref( resource ) );
        }

        return list1;
    }

    protected void partyHrefToParty1(PartyHref partyHref, Party mappingTarget) {
        if ( partyHref == null ) {
            return;
        }

        if ( partyHref.getId() != null ) {
            mappingTarget.setId( partyHref.getId() );
        }
        if ( partyHref.getUuid() != null ) {
            mappingTarget.setUuid( partyHref.getUuid() );
        }
        if ( partyHref.getHref() != null ) {
            mappingTarget.setHref( partyHref.getHref() );
        }
    }

    protected void orderHrefToOrderEntity1(OrderHref orderHref, OrderEntity mappingTarget) {
        if ( orderHref == null ) {
            return;
        }

        if ( orderHref.getId() != null ) {
            mappingTarget.setId( orderHref.getId() );
        }
        if ( orderHref.getHref() != null ) {
            mappingTarget.setHref( orderHref.getHref() );
        }
        if ( orderHref.getUuid() != null ) {
            mappingTarget.setUuid( orderHref.getUuid() );
        }
        if ( orderHref.getName() != null ) {
            mappingTarget.setName( orderHref.getName() );
        }
    }
}
