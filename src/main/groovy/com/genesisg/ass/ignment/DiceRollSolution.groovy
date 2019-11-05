package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.util.Dice
import com.genesisg.ass.ignment.util.LoadedDice
import com.genesisg.ass.ignment.util.RealDice

/**
 * A solution to rolling a dice XD.
 */
class DiceRollSolution implements Solution {

    private Dice dice

    /**
     * max retry count, can be set by different employee type
     */
    int retry = 1

    DiceRollSolution() {
        this(new RealDice())
    }

    DiceRollSolution(Dice dice) {
        this.dice = dice
    }

    int roll() {
        dice.roll()
    }

    /**
     * get dice roll solution instance with loaded dice for test usage.
     * @param loadedNum
     */
    static DiceRollSolution withLoadedDice(int loadedNum) {
        new DiceRollSolution(new LoadedDice(loadedNum))
    }

}

