package com.genesisg.ass.ignment.util

/**
 * Loaded dice can roll what you want.
 */
class LoadedDice implements Dice {

    int loaded

    LoadedDice(int loaded) {
        this.loaded = loaded
    }

    int roll() {
        loaded
    }

}
