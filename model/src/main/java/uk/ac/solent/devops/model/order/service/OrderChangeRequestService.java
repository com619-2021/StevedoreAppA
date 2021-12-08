package uk.ac.solent.devops.model.order.service;

import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.order.dto.Order;

public interface OrderChangeRequestService {

    public ReplyMessage getOrderChangeRequestByUuid(String uuid);

    public ReplyMessage deleteOrderChangeRequestByUuid(String uuid);

    public ReplyMessage postCreateOrderChangeRequest(Order order, String ownerPartyUUID);

    public ReplyMessage putUpdateOrderChangeRequest(Order order);

    public ReplyMessage getOrderChangeRequestByTemplate(Order orderSearchTemplate, Integer offset, Integer limit);
}
