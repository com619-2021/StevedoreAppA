package uk.ac.solent.devops.model.party.dto;

import lombok.*;
import uk.ac.solent.devops.model.base.Model;
import uk.ac.solent.devops.model.user.dto.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "parties")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class Party extends Model {

    @GeneratedValue
    private UUID uuid;

    private String name;

    @ManyToOne
    @JoinColumn(name = "party_user_id")
    private User partyUser;

    private PartyRole role;

    private boolean active;

}
