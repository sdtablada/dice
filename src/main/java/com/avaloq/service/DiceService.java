package com.avaloq.service;

import com.avaloq.dao.DiceRollDao;
import com.avaloq.dto.DiceRollDTO;
import com.avaloq.dto.DiceRollRequestDTO;
import com.avaloq.model.Dice;
import com.avaloq.model.DiceRoll;
import com.avaloq.model.DiceRollDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiceService {

    @Autowired
    private DiceRollDao diceRollDao;

    public List<DiceRollDTO> simulate(final DiceRollRequestDTO diceRollRequestDTO) {
        final int numberOfDice = diceRollRequestDTO.getNumberOfDice();
        final int numberOfFaces = diceRollRequestDTO.getNumberOfFaces();
        final int numberOfRolls = diceRollRequestDTO.getNumberOfRolls();

        DiceRoll diceRoll = new DiceRoll(numberOfDice, numberOfFaces, numberOfRolls);

        populateDiceRollDetails(numberOfDice, numberOfFaces, numberOfRolls, diceRoll);

        return diceRollDao.getTotalByRolledSum(diceRollDao.save(diceRoll).getSimulationId());
    }

    private void populateDiceRollDetails(int numberOfDice, int numberOfFaces,
                                         int numberOfRolls, DiceRoll diceRoll) {
        for (int i = 0; i < numberOfRolls; i++) {
            DiceRollDetails diceRollDetails = new DiceRollDetails(diceRoll);
            int sum = 0;

            for (int j = 0; j < numberOfDice; j++) {
                Dice dice = new Dice(numberOfFaces);
                sum = sum + dice.roll();
            }

            diceRollDetails.setRolledSum(sum);
            diceRoll.addDiceRollDetails(diceRollDetails);
        }
    }
}
