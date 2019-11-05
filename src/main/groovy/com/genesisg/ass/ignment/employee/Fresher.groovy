package com.genesisg.ass.ignment.employee
/**
 * Level 1 employee, provide a dice roll solution with 3 retry limit.
 * If a fresher is unable to solve the caller's problem,
 * he or she must escalate the call to technical lead.
 */
class Fresher extends Employee {

    Fresher(String name) {
        this.name = "Fresher($name)"
        solution = new DiceRollSolution(retry: 3)
        level = 1
    }

}
