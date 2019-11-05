package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.employee.AllFreeSolution
import com.genesisg.ass.ignment.employee.DiceRollSolution
import com.genesisg.ass.ignment.employee.Solution
import com.genesisg.ass.ignment.util.Dice
import com.genesisg.ass.ignment.util.LoadedDice
import com.genesisg.ass.ignment.util.RealDice

class DiceRollProblem extends BaseProblem {

    final static int RETRY_SLEEP_TIME_MILLIS = 1000

    private int problem

    DiceRollProblem() {
        this(new RealDice())
    }

    DiceRollProblem(Dice dice) {
        problem = dice.roll()
    }

    @Override
    boolean resolveBy(Solution solution) {
        if (solution instanceof AllFreeSolution) {
            resolved = true
        } else if (solution instanceof DiceRollSolution) {
            int retry = 0
            while (!resolved && (retry++) < solution.retry) {
                Thread.sleep(new Random().nextInt(RETRY_SLEEP_TIME_MILLIS))
                resolved = (problem == solution.roll())
            }
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
