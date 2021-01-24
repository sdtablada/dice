package com.avaloq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiceRollDTO {

    private int rolledSum;

    private long total;

    public DiceRollDTO(int rolledSum, long total) {
        this.rolledSum = rolledSum;
        this.total = total;
    }
}
