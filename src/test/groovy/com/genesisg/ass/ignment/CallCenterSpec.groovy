package com.genesisg.ass.ignment

import spock.lang.Specification

import static java.util.concurrent.TimeUnit.*

/**
 * test about call center
 */
class CallCenterSpec extends Specification {

    CallCenter callCenter

    def setup() {
        callCenter = new CallCenter()
    }

    def cleanup() {
        callCenter.stop()
    }

    def "employee can resolve customer's problem, if he can roll out the same number"() {
        given:
        def andyRoddick = new Employee(
            name: "AndyRoddick",
            solution: DiceRollSolution.withLoadedDice(1),
            level: 1
        )

        def customer = new Customer(
            name: "Customer",
            problem: DiceRollProblem.withLoadedDice(1)
        )

        when:
        callCenter
            .hire(andyRoddick)
            .onCall()
            .sendAndWait(new Call(customer: customer), 1, SECONDS)

        then:
        assert customer.problem.resolved
        assert customer.problem.resolver.name == "AndyRoddick"
    }

    def "call center will dispatch calls to the lower level employee first"() {
        given:
        def lv1Emp = new Employee(
            name: "lv1Emp",
            solution: DiceRollSolution.withLoadedDice(1),
            level: 1
        )

        def lv2Emp = new Employee(
            name: "lv2Emp",
            solution: DiceRollSolution.withLoadedDice(1),
            level: 2
        )

        def customer = new Customer(
            name: "Customer",
            problem: DiceRollProblem.withLoadedDice(1)
        )

        when:
        callCenter
            .hire(lv2Emp)
            .hire(lv1Emp)
            .onCall()
            .sendAndWait(new Call(customer: customer), 1, SECONDS)

        then:
        assert customer.problem.resolver.name == "lv1Emp"
        assert customer.problem.resolver.level == 1
    }

    def "lower level employee will escalate the call to higher level employee, if he can't roll out the same number"() {
        given:
        def lv1Employee = new Employee(
            name: "AndyRoddick",
            solution: DiceRollSolution.withLoadedDice(1),
            level: 1
        )

        def lv2Employee = new Employee(
            name: "RogerFederer",
            solution: DiceRollSolution.withLoadedDice(2),
            level: 2
        )

        def customer = new Customer(
            name: "Customer",
            problem: DiceRollProblem.withLoadedDice(2)
        )

        when:
        callCenter
            .hire(lv1Employee)
            .hire(lv2Employee)
            .onCall()
            .sendAndWait(new Call(customer: customer), 1, SECONDS)

        then:
        assert customer.problem.resolved
        assert customer.problem.resolver.name == "RogerFederer"
    }

}
