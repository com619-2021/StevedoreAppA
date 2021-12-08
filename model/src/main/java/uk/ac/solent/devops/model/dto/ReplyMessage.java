package uk.ac.solent.devops.model.dto;

import uk.ac.solent.devops.model.order.dto.Order;
import uk.ac.solent.devops.model.order.dto.OrderChangeRequest;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.resource.dto.Resource;
import uk.ac.solent.devops.model.resource.dto.ResourceCatalog;
import uk.ac.solent.devops.model.user.dto.User;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ReplyMessage {

    private Integer code = null;

    private String debugMessage = null;

    private Long totalCount = null;

    private Integer offset = null;

    private Integer limit = null;

    @XmlElementWrapper(name = "stringlist")
    @XmlElement(name = "string")
    private List<String> stringList = null;

    @XmlElementWrapper(name = "partylist")
    @XmlElement(name = "party")
    private List<Party> partyList = null;

    @XmlElementWrapper(name = "userlist")
    @XmlElement(name = "user")
    private List<User> userList = null;

    @XmlElementWrapper(name = "resourceList")
    @XmlElement(name = "resource")
    private List<Resource> resourceList = null;

    @XmlElementWrapper(name = "resourceCatalogList")
    @XmlElement(name = "resourceCatalog")
    private List<ResourceCatalog> resourceCatalogList = null;

    @XmlElementWrapper(name = "orderChangeRequestList")
    @XmlElement(name = "orderChangeRequest")
    private List<OrderChangeRequest> orderChangeRequestList = null;

    @XmlElementWrapper(name = "orderList")
    @XmlElement(name = "order")
    private List<Order> orderList = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Party> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<Party> partyList) {
        this.partyList = partyList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<ResourceCatalog> getResourceCatalogList() {
        return resourceCatalogList;
    }

    public void setResourceCatalogList(List<ResourceCatalog> resourceCatalogList) {
        this.resourceCatalogList = resourceCatalogList;
    }

    public List<OrderChangeRequest> getOrderChangeRequestList() {
        return orderChangeRequestList;
    }

    public void setOrderChangeRequestList(List<OrderChangeRequest> orderChangeRequestList) {
        this.orderChangeRequestList = orderChangeRequestList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "ReplyMessage{" + "code=" + code + ", debugMessage=" + debugMessage + ", totalCount=" + totalCount + ", offset=" + offset + ", limit=" + limit + ", stringList=" + stringList + ", partyList=" + partyList + ", userList=" + userList + ", resourceList=" + resourceList + ", resourceCatalogList=" + resourceCatalogList + ", orderChangeRequestList=" + orderChangeRequestList + ", orderList=" + orderList + '}';
    }
    
    

}
