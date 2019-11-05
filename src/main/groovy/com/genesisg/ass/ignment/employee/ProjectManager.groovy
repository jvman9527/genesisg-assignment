package com.genesisg.ass.ignment.employee
/**
 * Level 10 employee, provide a dice roll solution with 9 retry limit
 * If the PM can not resolve callers' problem, she must escalate to her boss.
 */
class ProjectManager extends Employee {

    ProjectManager(String name) {
        this.name = "PM($name)"
        solution = new DiceRollSolution(retry: 9)
        level = 10
    }

}
