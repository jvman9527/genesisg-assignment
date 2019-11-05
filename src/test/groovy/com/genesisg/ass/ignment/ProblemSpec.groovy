package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.customer.DiceRollProblem
import com.genesisg.ass.ignment.employee.DiceRollSolution
import com.genesisg.ass.ignment.util.LoadedDice
import spock.lang.Specification

/**
 * Problem Spec
 */
class ProblemSpec extends Specification {

    def "problem initially not resolved"() {
        given:
        def problem = new DiceRollProblem()

        expect:
        !problem.resolved
    }

    def "dice roll problem may resolve by a dice roll solution"() {
        setup:
        DiceRollProblem problem = new DiceRollProblem()
        DiceRollSolution solution = Mock()

        when:
        problem.resolveBy(solution)

        then:
        1 * solution.roll()
    }

    def "The dice roll problem will be resolved if dice roll solution generate the same number, otherwise no."(int x, int y, boolean resolved) {
        setup:
        DiceRollProblem problem = new DiceRollProblem(new LoadedDice(x))
        DiceRollSolution solution = new DiceRollSolution(new LoadedDice(y))

        expect:
        problem.resolveBy(solution) == resolved

        where:
        x | y | resolved
        1 | 1 | true
        2 | 2 | true
        3 | 4 | false
        5 | 6 | false
    }

}
