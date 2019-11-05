package com.genesisg.ass.ignment.employee
/**
 * Level 5 employee, provide a dice roll solution with 6 retry limit.
 * If the TL is not free or not able to handle it, then the call should be escalated to the PM.
 */
class TechnicalLead extends Employee {

    TechnicalLead(String name) {
        this.name = "TL($name)"
        solution = new DiceRollSolution(retry: 6)
        level = 5
    }

}
