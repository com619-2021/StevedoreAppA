package uk.ca.solent.devops.stevedore.model.order;

import lombok.*;
import uk.ca.solent.devops.stevedore.model.PartyExecutor;
import uk.ca.solent.devops.stevedore.model.base.Model;
import uk.ca.solent.devops.stevedore.model.request.OrderChangeRequestModel;
import uk.ca.solent.devops.stevedore.model.ros.ResourceOrServiceModel;
import uk.ca.solent.devops.stevedore.model.ros.ResourceType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "orders")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class OrderModel extends Model {

    @GeneratedValue
    private UUID uuid;


    private String name;

    @OneToMany
    @ToString.Exclude
    private List<OrderModel> subOrders;

    private String description;

    private Date orderDate;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private PartyExecutor orderOwner;

    @OneToMany
    @ToString.Exclude
    private List<OrderChangeRequestModel> changeRequests;

    @OneToOne
    private OrderModel parentOrder;

    @ElementCollection
    @CollectionTable(
            name = "resource_or_service",
            joinColumns = @JoinColumn(name = "ORDER_ID")
    )
    private List<ResourceOrServiceModel> resourcesOrService;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private ResourceType orderType;

}
