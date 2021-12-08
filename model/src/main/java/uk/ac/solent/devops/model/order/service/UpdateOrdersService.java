package uk.ac.solent.devops.model.order.service;

import uk.ac.solent.devops.model.dto.ReplyMessage;
import uk.ac.solent.devops.model.order.dto.Order;

public interface UpdateOrdersService {

    public ReplyMessage postCreateOrder(Order orderRequest, String changeRequestorUuid, String changeReason);

    public ReplyMessage postCancelOrder(String orderUuid, String changeRequestorUuid, String changeReason);

    public ReplyMessage postConfirmOrder(String orderUuid, String changeRequestorUuid, String changeReason);

    public ReplyMessage postPlaceExternalOrder(String orderUuid, String changeRequestorUuid, String changeReason);

    public ReplyMessage postAddSubOrder(String parentOrderUuid, String childOrderUuid, String changeRequestorUuid, String changeReason);

    public ReplyMessage postRemoveSubOrder(String parentOrderUuid, String childOrderUuid, String changeRequestorUuid, String changeReason);

    public ReplyMessage postOrderChangeRequest(Order changeRequest, String changeRequestorUuid, String changeReason);

    public ReplyMessage postAcceptOrderChangeRequest(String changeRequestUuid, String responseDescription);

    public ReplyMessage postRejectOrderChangeRequest(String changeRequestUuid, String responseDescription);
}
