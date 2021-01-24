package com.avaloq.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DICE_ROLL")
public class DiceRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int simulationId;

    private int noOfDice;

    private int noOfDiceFaces;

    private int noOfRolls;

    @OneToMany(mappedBy = "diceRoll", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiceRollDetails> diceRollDetails = new ArrayList<>();

    public DiceRoll(int noOfDice, int noOfDiceFaces, int noOfRolls) {
        this.noOfDice = noOfDice;
        this.noOfDiceFaces = noOfDiceFaces;
        this.noOfRolls = noOfRolls;
    }

    public void addDiceRollDetails(DiceRollDetails diceRollDetails) {
        this.diceRollDetails.add(diceRollDetails);
    }
}
