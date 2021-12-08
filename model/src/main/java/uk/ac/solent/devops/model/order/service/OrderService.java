package uk.ac.solent.devops.model.order.service;

import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.order.dto.Order;

public interface OrderService {

    public ReplyMessage getOrderByUuid(String uuid);

    public ReplyMessage deleteOrderByUuid(String uuid);

    public ReplyMessage postCreateOrder(Order order, String ownerPartyUUID);

    public ReplyMessage putUpdateOrder(Order order);

    public ReplyMessage getOrderByTemplate(Order orderSearchTemplate, Integer offset, Integer limit);
}
