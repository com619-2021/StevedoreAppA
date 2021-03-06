package uk.ac.solent.devops.model.order.dto;

import lombok.*;
import uk.ac.solent.devops.model.base.Model;
import uk.ac.solent.devops.model.order.OrderStatus;
import uk.ac.solent.devops.model.service.ResourceType;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@Table(name = "orders")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class Order extends Model {

    @GeneratedValue
    private UUID uuid;

    private String name;

    private String description;

    private Date orderDate;

    private Date startDate;

    private Date endDate;

    //@OneToOne
    //@JoinColumn(name = "party_ID")
    //private Party party;

    //@ManyToMany
    //private List<ServiceModel> services = new java.util.ArrayList<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private ResourceType orderType;

}
