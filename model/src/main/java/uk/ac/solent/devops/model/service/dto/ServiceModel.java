package uk.ac.solent.devops.model.service.dto;

import lombok.*;
import uk.ac.solent.devops.model.base.Model;
import uk.ac.solent.devops.model.service.ResourceType;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@Table(name = "services")
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class ServiceModel extends Model {

    @GeneratedValue
    private UUID uuid;

    private String name;

    private String value;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
}
