package uk.ca.solent.devops.stevedore.model.ros;

import lombok.*;
import uk.ca.solent.devops.stevedore.model.PartyExecutor;
import uk.ca.solent.devops.stevedore.model.base.Model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Builder
@Table(name = "resource")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class ResourceOrServiceModel extends Model {

    @GeneratedValue
    private UUID uuid;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "character_id",
            joinColumns = @JoinColumn(name = "character_id")
    )
    private List<Characteristics> characteristics;

    @Enumerated(EnumType.STRING)
    private PartyExecutor partyExecutor;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

}
