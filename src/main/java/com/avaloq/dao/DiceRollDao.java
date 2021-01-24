package com.avaloq.dao;

import com.avaloq.model.DiceRoll;
import com.avaloq.dto.DiceRollDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiceRollDao extends CrudRepository<DiceRoll, Integer> {

    @Query("SELECT new com.avaloq.dto.DiceRollDTO(drd.rolledSum as rolledSum, count(drd.rolledSum) as total) from DiceRoll dr " +
            "INNER JOIN dr.diceRollDetails drd " +
            "where dr.simulationId = ?1 " +
            "group by drd.rolledSum " +
            "order by drd.rolledSum")
    List<DiceRollDTO> getTotalByRolledSum(int simulationId);

}
