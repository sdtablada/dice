# DiceSimulation
DiceSimulation contains the following REST APIs:

## roll-dice
Simulates rolling of dice and returns an object containing the total number of rolls where a sum has been rolled.
```bash
curl --header "Content-Type: application/json" --request POST \--data '{"numberOfDice":1,"numberOfFaces":4,"numberOfRolls":1}' "http://localhost:8080/roll-dice"
```

## get-roll-summary
Returns number of rolls and simulation for a particular dice-number/dice-side simulation
```bash
curl "http://localhost:8080/get-roll-summary"
```

## get-roll-distribution
Returns the relative distribution of a rolled sum based on the dice-number/dice-side combination
```bash
curl "http://localhost:8080/get-roll-distribution?numberOfDice=1&numberOfFaces=4"
```
## Consideration
H2 database was used for this solution