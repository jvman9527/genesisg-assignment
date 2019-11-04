package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.employee.Employee
import groovyx.gpars.actor.DefaultActor

class CallCenter extends DefaultActor {

    List<Employee> employees = []

    void act() {
        loop {
            react { msg ->
                if (msg instanceof Call) {
                    callEmployee(msg.customer)
                } else if (msg instanceof Escalate) {
                    msg.from.free = true
                    callEmployee(msg.customer, msg.from.level)
                } else if (msg instanceof Done) {
                    msg.customer.problem.resolver.free = true
                    println "${msg.customer.name} resolved by ${msg.customer.problem.resolver.name}"
                }
            }
        }
    }

    void callEmployee(Customer customer, int level = 0) {
        def emp = employees.find { it.free && it.level > level }
        emp.free = false
        emp << customer
    }

    CallCenter hire(Employee employee) {
        employees << employee
        employees.sort { it.level }
        this
    }

    CallCenter onCall() {
        start()
        this
    }

}

