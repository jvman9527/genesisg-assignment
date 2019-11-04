package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.util.Dice
import com.genesisg.ass.ignment.util.LoadedDice
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

    /**
     * get dice roll problem instance with loaded dice for test usage.
     * @param loadedNum
     */
    static DiceRollProblem withLoadedDice(int loadedNum) {
        new DiceRollProblem(new LoadedDice(loadedNum))
    }

}
