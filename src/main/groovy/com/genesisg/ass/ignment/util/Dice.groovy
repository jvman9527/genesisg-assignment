package com.genesisg.ass.ignment.util

/**
 * Dice can simulate rolling numbers from 0 - 5
 */
class Dice {

    private random = new Random()

    int roll() {
        random.nextInt(6)
    }

}
