package com.genesisg.ass.ignment.util

/**
 * Dice can randomly rolling numbers from 0 - 5
 */
class RealDice implements Dice {

    private random = new Random()

    int roll() {
        random.nextInt(6)
    }

}
