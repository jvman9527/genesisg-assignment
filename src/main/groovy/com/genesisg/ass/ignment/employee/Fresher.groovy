package com.genesisg.ass.ignment.employee

import com.genesisg.ass.ignment.DiceRollSolution

class Fresher extends Employee {

    Fresher(String name) {
        this.name = "Fresher($name)"
        solution = new DiceRollSolution()
        level = 1
    }

}
