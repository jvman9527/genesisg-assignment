package com.genesisg.ass.ignment.util

import spock.lang.Specification

class DiceSpec extends Specification {

    def "Real dice can roll from 0 to 5"() {
        given:
        def dice = new RealDice()

        expect:
        (1..100).every { dice.roll() in (0..5) }
    }

    def "Loaded dice can roll what you want"() {
        expect:
        new LoadedDice(x).roll() == y

        where:
        x | y
        1 | 1
        2 | 2
        6 | 6
    }

}
