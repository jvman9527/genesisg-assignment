package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.util.Dice

/**
 * A solution to rolling a dice XD.
 */
class DiceRollSolution implements Solution {

    private dice = new Dice()

    int roll() {
        dice.roll()
    }

}

