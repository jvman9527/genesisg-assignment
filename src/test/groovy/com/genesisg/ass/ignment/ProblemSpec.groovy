package com.genesisg.ass.ignment

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

}
