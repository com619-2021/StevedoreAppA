package uk.ac.solent.devops.model.order.dto;

import uk.ac.solent.devops.model.party.dto.PartyHref;
import uk.ac.solent.devops.model.resource.dto.ResourceAccess;
import uk.ac.solent.devops.model.resource.dto.ResourceHref;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    private String href;

    private String uuid;

    private Long id;

    private String name;

    @XmlElementWrapper(name = "subOrdersList")
    @XmlElement(name = "subOrder")
    private List<OrderHref> subOrders;

    private String description;

    private Date orderDate;

    private Date startDate;

    private Date endDate;

    private PartyHref orderOwner;

    @XmlElementWrapper(name = "changeRequestsList")
    @XmlElement(name = "orderChangeRequestHref")
    private List<OrderChangeRequestHref> changeRequests;

    private OrderHref parentOrder;

    @XmlElementWrapper(name = "resourceList")
    @XmlElement(name = "resourceHref")
    private List<ResourceHref> resourceOrService;

    private OrderStatus status;

    private ResourceAccess resourceAccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<OrderHref> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<OrderHref> subOrders) {
        this.subOrders = subOrders;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public PartyHref getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(PartyHref orderOwner) {
        this.orderOwner = orderOwner;
    }


    public List<OrderChangeRequestHref> getChangeRequests() {
        return changeRequests;
    }

    public void setChangeRequests(List<OrderChangeRequestHref> changeRequests) {
        this.changeRequests = changeRequests;
    }


    public OrderHref getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(OrderHref parentOrder) {
        this.parentOrder = parentOrder;
    }

    public List<ResourceHref> getResourceOrService() {
        return resourceOrService;
    }

    public void setResourceOrService(List<ResourceHref> resourceOrService) {
        this.resourceOrService = resourceOrService;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public ResourceAccess getResourceAccess() {
        return resourceAccess;
    }

    public void setResourceAccess(ResourceAccess resourceAccess) {
        this.resourceAccess = resourceAccess;
    }

}
