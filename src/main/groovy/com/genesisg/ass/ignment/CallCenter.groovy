package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.customer.Customer
import com.genesisg.ass.ignment.customer.DiceRollProblem
import com.genesisg.ass.ignment.employee.Boss
import com.genesisg.ass.ignment.employee.Employee
import com.genesisg.ass.ignment.employee.Fresher
import com.genesisg.ass.ignment.employee.ProjectManager
import com.genesisg.ass.ignment.employee.TechnicalLead
import groovyx.gpars.actor.DefaultActor

/**
 * Call center responsible for allocating calls to employee, and control their work status.
 * It will try to dispatch call to lower level employee first if they are free,
 * If the employee can not resolve the problem, it escalate the call to the higher level one
 */
class CallCenter extends DefaultActor {

    /**
     * the current employees in the call center
     */
    List<Employee> employees = []

    /**
     * handle the call allocating logic
     */
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

    /**
     * @param customer
     * @param level - used to find the employee higher then this value
     */
    void callEmployee(Customer customer, int level = 0) {
        def emp = employees.find { it.free && it.level > level }
        emp.free = false
        emp << customer
    }

    /**
     * you should hire some employee before you face to the customers
     * @param employee
     */
    CallCenter hire(Employee employee) {
        employees << employee
        employees.sort { it.level }
        this
    }

    /**
     * start operation of this call center
     * @return
     */
    CallCenter onCall() {
        start()
        this
    }

    /**
     * simple example
     * 3 freshers
     * 1 tech lead
     * 1 project manager
     * 1 boss
     *
     * there's an incoming call every second, and it never stop.
     */
    static void main(args) {
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

