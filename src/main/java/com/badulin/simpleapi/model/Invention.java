package com.badulin.simpleapi.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "inventions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String inventor;

    @NotNull
    private String year;

    public Invention(long id, String name, String inventor, String year) {
        this.id = id;
        this.name = name;
        this.inventor = inventor;
        this.year = year;
    }

    public Invention(String name, String inventor, String year) {
        this.name = name;
        this.inventor = inventor;
        this.year = year;
    }


    public Invention() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
