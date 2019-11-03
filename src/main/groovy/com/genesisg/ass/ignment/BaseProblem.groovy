package com.genesisg.ass.ignment

/**
 * Default problem support
 */
abstract class BaseProblem implements Problem {

    /**
     * the problem resolved status.
     */
    protected resolved = false

    abstract boolean resolveBy(Solution solution)

    @Override
    boolean isResolved() {
        return resolved
    }

}

