package com.genesisg.ass.ignment

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
     * @return is this problem resolved
     */
    boolean isResolved()

}