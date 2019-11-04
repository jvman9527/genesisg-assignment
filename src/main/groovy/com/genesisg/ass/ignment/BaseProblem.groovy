package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.employee.Employee

/**
 * Default problem support
 */
abstract class BaseProblem implements Problem {

    /**
     * the problem resolved status.
     */
    protected resolved = false

    /**
     * the Employee who resolve the problem
     */
    Employee resolver

    abstract boolean resolveBy(Solution solution)

    @Override
    boolean isResolved() {
        return resolved
    }

}

