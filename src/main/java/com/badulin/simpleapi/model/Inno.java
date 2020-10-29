package com.badulin.simpleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "inno")
public class Inno extends AbstractBaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String year;
    @NotBlank
    private String app_area;
  //  @NotNull
  //  private Long inventor_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventor_id", nullable = false)
    private Invention invention;
}
