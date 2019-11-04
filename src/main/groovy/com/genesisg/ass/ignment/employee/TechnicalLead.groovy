package com.genesisg.ass.ignment.employee

import com.genesisg.ass.ignment.DiceRollSolution

class TechnicalLead extends Employee {

    TechnicalLead(String name) {
        this.name = "TL($name)"
        solution = new DiceRollSolution()
        level = 5
    }

}
