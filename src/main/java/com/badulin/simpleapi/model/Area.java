package com.badulin.simpleapi.model;

import com.fasterxml.jackson.annotation.*;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "areas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Area  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String area;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inv_id", nullable = false)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("inv_id")
    private Invention inv;

    public Area(Long id, String area) {
        this.id = id;
        this.area = area;
    }

    public Area(String area) {
        this.area = area;
    }

    public Area() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Invention getInventions() {
        return inv;
    }

    public void setInventions(Invention inv) {
        this.inv = inv;
    }

}
