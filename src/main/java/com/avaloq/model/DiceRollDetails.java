package com.avaloq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "DICE_ROLL_DETAILS")
public class DiceRollDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int rolledSum;

    @ManyToOne(optional = false)
    @JsonIgnore
    private DiceRoll diceRoll;

    public DiceRollDetails(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

}
