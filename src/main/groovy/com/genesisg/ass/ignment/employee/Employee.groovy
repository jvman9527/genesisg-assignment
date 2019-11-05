package com.genesisg.ass.ignment.employee

import com.genesisg.ass.ignment.Customer
import com.genesisg.ass.ignment.Done
import com.genesisg.ass.ignment.Escalate
import groovyx.gpars.actor.DefaultActor

/**
 * An Employee can provide a solution to his customer.
 */
class Employee extends DefaultActor {

    String name

    Solution solution

    /**
     * determine whether the call allocate to this employee
     */
    boolean free = true

    /**
     * Level help determine the order of a customer call allocate to.
     */
    int level

    Employee() {
        start()
    }

    void act() {
        loop {
            react { Customer customer ->
                if (customer.problem.resolveBy(solution)) {
                    customer.problem.resolver = this
                    reply new Done(customer: customer)
                } else {
                    reply new Escalate(customer: customer, from: this)
                }
            }
        }
    }

}

