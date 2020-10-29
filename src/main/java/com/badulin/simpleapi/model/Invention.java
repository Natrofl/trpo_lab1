package com.badulin.simpleapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)


@Table(name = "invention")
public class Invention extends AbstractBaseEntity {

    @NotBlank
    private String inventor;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Inno> inno;

}
