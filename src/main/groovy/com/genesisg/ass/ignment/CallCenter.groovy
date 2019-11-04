package com.genesisg.ass.ignment

import groovyx.gpars.actor.DefaultActor

class CallCenter extends DefaultActor {

    List<Employee> employees = []

    void act() {
        loop {
            react { msg ->
                if (msg instanceof Call) {
                    callEmployee(msg.customer)
                } else if (msg instanceof Escalate) {
                    callEmployee(msg.customer, msg.from.level)
                } else if (msg instanceof Done) {
                    println "${msg.customer.name} resolved by ${msg.customer.problem.resolver.name}"
                }
            }
        }
    }

    void callEmployee(Customer customer, int level = 0) {
        employees
            .find { it.level > level }
            .send(customer)
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

