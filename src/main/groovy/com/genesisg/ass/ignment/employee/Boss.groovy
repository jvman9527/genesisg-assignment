package com.genesisg.ass.ignment.employee

import com.genesisg.ass.ignment.AllFreeSolution

/**
 * Most powerful guy who can solve any problem and free at anytime
 */
class Boss extends Employee {

    Boss(String name) {
        this.name = "Boss($name)"
        solution = new AllFreeSolution()
        level = 100
    }

    /**
     * boss always free at anytime
     * @param free
     */
    @Override
    final void setFree(boolean free) { /* do nothing */ }

}

