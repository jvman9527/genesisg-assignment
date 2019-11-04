package com.genesisg.ass.ignment.employee

import com.genesisg.ass.ignment.DiceRollSolution

class ProjectManager extends Employee {

    ProjectManager(String name) {
        this.name = "PM($name)"
        solution = new DiceRollSolution()
        level = 10
    }

}
