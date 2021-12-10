package uk.ac.solent.devops.model.request.dto;

import lombok.*;
import uk.ac.solent.devops.model.base.Model;
import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.request.ChangeStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "order_change_request")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class OrderChangeRequest extends Model {

    @GeneratedValue
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "party_ID")
    private Party party;

    private String note;

    private Date requestDate;

    private Date approvedDate;

    private String changeReason;

    @Enumerated(EnumType.STRING)
    private ChangeStatus changeStatus;




}
