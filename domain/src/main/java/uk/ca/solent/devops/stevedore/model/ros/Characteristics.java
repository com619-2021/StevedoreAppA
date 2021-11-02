package uk.ca.solent.devops.stevedore.model.ros;


import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@ToString(callSuper = true)
@NoArgsConstructor(force = true)
public class Characteristics {
    private String name;
    private String value;
}
