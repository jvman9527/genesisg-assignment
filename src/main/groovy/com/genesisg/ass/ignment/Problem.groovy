package com.genesisg.ass.ignment

import com.genesisg.ass.ignment.employee.Employee

/**
 * A Problem may resolve by a solution
 */
interface Problem {

    /**
     * @param solution
     * @return is this problem resolved
     */
    boolean resolveBy(Solution solution)

    /**
     * set the problem resolver
     */
    void setResolver(Employee employee)

    /**
     * @return the problem resolver if it resolved, otherwise null
     */
    Employee getResolver()

    /**
     * @return is this problem resolved
     */
    boolean isResolved()

}