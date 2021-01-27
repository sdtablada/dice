package com.avaloq.dao;

import com.avaloq.dto.DiceRollDTO;
import com.avaloq.dto.DiceSummaryDTO;
import com.avaloq.model.DiceRoll;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface DiceRollDao extends CrudRepository<DiceRoll, Integer> {

    @Query("SELECT new com.avaloq.dto.DiceRollDTO(drd.rolledSum as rolledSum, count(drd.rolledSum) as total) " +
            "from DiceRoll dr " +
            "INNER JOIN dr.diceRollDetails drd " +
            "where dr.simulationId = ?1 " +
            "group by drd.rolledSum " +
            "order by drd.rolledSum")
    List<DiceRollDTO> getTotalByRolledSum(int simulationId);

    @Query("SELECT new com.avaloq.dto.DiceSummaryDTO(dr.noOfDice, dr.noOfDiceFaces, count(dr.noOfRolls) as simulations, " +
            "sum(dr.noOfRolls) as rolls) from DiceRoll dr " +
            "group by dr.noOfDice, dr.noOfDiceFaces")
    List<DiceSummaryDTO> getDiceRollSummary();

    @Query(value = "select rolled_sum, cast(count(rolled_sum)/cast(summary.sum as decimal(10,2))*100 as decimal (10,2)) " +
            "from " +
            "(select count(rolled_sum) as sum from dice_roll_details " +
            "left join dice_roll on simulation_id=dice_roll_simulation_id " +
            "where no_of_dice=?1 and no_of_dice_faces=?2) summary, dice_roll dr " +
            "left join dice_roll_details drd " +
            "on dr.SIMULATION_ID = drd.DICE_ROLL_SIMULATION_ID " +
            "where dr.no_of_dice=?1 and dr.no_of_dice_faces=?2 " +
            "group by rolled_sum, summary.sum", nativeQuery = true)
    List<Double[]> getDiceDistribution(int noOfDice, int noOfDiceFaces);

}
