package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.util.Dice

class DiceRollProblem extends BaseProblem {

    private int problem = new Dice().roll()

    @Override
    boolean resolveBy(Solution solution) {
        if (solution instanceof DiceRollSolution) {
            resolved = (problem == solution.roll())
        }

        resolved
    }

}
