package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.util.Dice
import com.genesisg.ass.ignment.util.RealDice

/**
 * A solution to rolling a dice XD.
 */
class DiceRollSolution implements Solution {

    private dice

    DiceRollSolution() {
        this(new RealDice())
    }

    DiceRollSolution(Dice dice) {
        this.dice = dice
    }

    int roll() {
        dice.roll()
    }

}

