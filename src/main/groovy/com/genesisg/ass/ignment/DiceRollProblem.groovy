package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.util.Dice
import com.genesisg.ass.ignment.util.RealDice

class DiceRollProblem extends BaseProblem {

    private int problem

    DiceRollProblem() {
        this(new RealDice())
    }

    DiceRollProblem(Dice dice) {
        problem = dice.roll()
    }

    @Override
    boolean resolveBy(Solution solution) {
        if (solution instanceof DiceRollSolution) {
            resolved = (problem == solution.roll())
        }

        resolved
    }

}
