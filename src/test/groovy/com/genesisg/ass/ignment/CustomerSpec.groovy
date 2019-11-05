package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.employee.DiceRollSolution
import com.genesisg.ass.ignment.employee.Employee
import com.genesisg.ass.ignment.util.LoadedDice
import spock.lang.Specification

/**
 *  Test about customer
 */
class CustomerSpec extends Specification {

    def "Customer's problem may resolved by employee's solution of a dice roll"(int x, int y, boolean resolved) {
        given:
        def customer = new Customer(name: "Rodick", problem: new DiceRollProblem(new LoadedDice(x)))
        def employee = new Employee(name: "GenesisEmp", solution: new DiceRollSolution(new LoadedDice(y)))

        expect:
        customer.problem.resolveBy(employee.solution) == resolved

        where:
        x | y | resolved
        1 | 1 | true
        2 | 3 | false
    }

}
