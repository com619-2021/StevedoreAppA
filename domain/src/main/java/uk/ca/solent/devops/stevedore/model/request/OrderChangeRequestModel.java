package uk.ca.solent.devops.stevedore.model.request;

import lombok.*;
import uk.ca.solent.devops.stevedore.model.PartyExecutor;
import uk.ca.solent.devops.stevedore.model.base.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Builder
@Entity
@Table(name = "requests")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class OrderChangeRequestModel extends Model {

    private UUID uuid;

    private String note;

    private Date requestDate;

    private Date approvedDate;

    @Enumerated(EnumType.STRING)
    private ChangeStatus changeStatus;

    private String changeReason;

    @Enumerated(EnumType.STRING)
    private PartyExecutor partyExecutor;

}
