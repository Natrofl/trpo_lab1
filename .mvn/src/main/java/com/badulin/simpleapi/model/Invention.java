package com.badulin.simpleapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Invention extends AbstractBaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String inventor;
    @NotBlank
    private String year;
    @NotBlank
    private String app_area;
}
