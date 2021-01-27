package com.avaloq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiceDistributionDTO {
    private Long rolledSum;

    private Long relativeDistribution;

    public DiceDistributionDTO(Long rolledSum, Long relativeDistribution) {
        this.rolledSum = rolledSum;
        this.relativeDistribution = relativeDistribution;
    }
}
