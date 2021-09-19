package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "amenity_enum")
public class Amenity {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne()
    private Home home;
    @Enumerated(EnumType.STRING)
    private String amenity;

}
