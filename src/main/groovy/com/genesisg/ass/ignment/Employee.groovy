package com.genesisg.ass.ignment

import groovyx.gpars.actor.DefaultActor

class Employee extends DefaultActor {

    String name

    Solution solution

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

