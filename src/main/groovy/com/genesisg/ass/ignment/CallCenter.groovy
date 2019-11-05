package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.employee.Boss
import com.genesisg.ass.ignment.employee.Employee
import com.genesisg.ass.ignment.employee.Fresher
import com.genesisg.ass.ignment.employee.ProjectManager
import com.genesisg.ass.ignment.employee.TechnicalLead
import groovyx.gpars.actor.DefaultActor

/**
 *
 */
class CallCenter extends DefaultActor {

    /**
     * the current employees in the call center
     */
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

    /**
     * simple test
     * @param args
     */
    static void main(args) {
        // 3 fresher, 1 TL, 1 PM, 1 Boss
        def callCenter = new CallCenter()
            .hire(new Boss("DavidStern"))
            .hire(new ProjectManager("Nadal"))
            .hire(new TechnicalLead("Federer"))
            .hire(new Fresher("Zverev"))
            .hire(new Fresher("Thiem"))
            .hire(new Fresher("Shapovalov"))
            .onCall()

        // call generator thread
        Thread.start {
            def counter = 1
            for (;;) {
                def c = new Customer(name: "Customer${counter++}", problem: new DiceRollProblem())
                callCenter << new Call(customer: c)
                Thread.sleep(1000)
            }
        }

        callCenter.join()
    }

}

