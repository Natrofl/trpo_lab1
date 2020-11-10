package com.badulin.simpleapi.model;

import com.fasterxml.jackson.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "areas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
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

    public Area(Long id) {
        this.id = id;
    }

    public Area(String area) {
        this.area = area;
    }

    public Area() {

    }

}
