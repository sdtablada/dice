package com.avaloq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiceSummaryDTO {
    private int noOfDice;
    private int noOfDiceFaces;
    private Long simulations;
    private Long rolls;

    public DiceSummaryDTO(int noOfDice, int noOfDiceFaces, Long simulations, Long rolls) {
        this.noOfDice = noOfDice;
        this.noOfDiceFaces = noOfDiceFaces;
        this.simulations = simulations;
        this.rolls = rolls;
    }
}
