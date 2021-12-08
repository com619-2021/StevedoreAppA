/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.order.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.party.dto.PartyHref;

/**
 * maps one abstract resource into another abstract resource can be used to map values of resource entity to dto objects
 *
 * @author cgallen
 */
@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity orderToOrderEntity(Order order);

    Order orderEntityToOrder(OrderEntity orderEntity);

    OrderHref orderToOrderHref(Order order);

    OrderHref orderEntityToOrderHref(OrderEntity orderEntity);

    OrderEntity updateOrderEntity(Order order, @MappingTarget OrderEntity orderEntity);

    @Mapping(source = "firstName", target = "name")
    PartyHref partyToHref(Party partyEntity);

}
