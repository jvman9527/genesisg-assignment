package com.genesisg.ass.ignment.employee

import com.genesisg.ass.ignment.Customer
import com.genesisg.ass.ignment.Done
import com.genesisg.ass.ignment.Escalate
import com.genesisg.ass.ignment.Solution
import groovyx.gpars.actor.DefaultActor

class Employee extends DefaultActor {

    String name

    Solution solution

    boolean free = true

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

