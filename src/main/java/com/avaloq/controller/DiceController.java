package com.avaloq.controller;

import com.avaloq.dto.DiceRollDTO;
import com.avaloq.dto.DiceRollRequestDTO;
import com.avaloq.dto.DiceSummaryDTO;
import com.avaloq.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin
public class DiceController {

    @Autowired
    private DiceService diceService;

    @PostMapping("/roll-dice")
    public List<DiceRollDTO> rollDice(@Valid @RequestBody DiceRollRequestDTO diceRollRequestDTO) {
        return diceService.simulate(diceRollRequestDTO);
    }

    @GetMapping("/get-roll-summary")
    public List<DiceSummaryDTO> getRollSummary() {
        return diceService.getDiceRollSummary();
    }


    @GetMapping("/get-roll-distribution")
    public List<Double[]> getDiceDistribution(@RequestParam(name = "numberOfDice") int numberOfDice,
                                              @RequestParam(name = "numberOfFaces") int numberOfFaces) {
        return diceService.getDiceDistribution(numberOfDice, numberOfFaces);
    }

}
