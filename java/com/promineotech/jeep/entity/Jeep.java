package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Jeep  implements Comparable<Jeep> {
    private Long modelPK;
    private JeepModel modelId;
    private String trimLevel;
    private int numDoors;
    private int wheelSize;
    private BigDecimal basePrice;
    
    @JsonIgnore   //this will leave out the primary key
    public Long getModelPK() {
      return modelPK;
    }

    @Override
    public int compareTo(Jeep that) {
      // @formatter: off
      return Comparator  // does the sorting by comparison
          .comparing(Jeep::getModelId)
          .thenComparing(Jeep::getTrimLevel)
          .thenComparing(Jeep::getNumDoors)
          .compare(this, that);
      // @formatter: on
    }

}