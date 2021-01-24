package com.avaloq.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class DiceRollRequestDTO {

    @Min(1)
    private int numberOfDice;

    @Min(4)
    private int numberOfFaces;

    @Min(1)
    private int numberOfRolls;

}
