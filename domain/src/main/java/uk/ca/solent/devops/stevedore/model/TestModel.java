package uk.ca.solent.devops.stevedore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TestModel {

    @Id
    private Long id;

    private String test;
}