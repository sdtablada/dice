package com.avaloq.controller;

import com.avaloq.dto.DiceRollDTO;
import com.avaloq.dto.DiceRollRequestDTO;
import com.avaloq.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class DiceController {

    @Autowired
    private DiceService diceService;

    @PostMapping("/roll-dice")
    public List<DiceRollDTO> rollDice(@Valid DiceRollRequestDTO diceRollRequestDTO) {

        return diceService.simulate(diceRollRequestDTO);

    }
}
