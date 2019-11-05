package com.genesisg.ass.ignment.employee

import spock.lang.Specification

class EmployeeSpec extends Specification {

    def "fresher is level 1 employee"() {
        expect:
        new Fresher("DominicThiem").level == 1
    }

    def "technical lead is level 5 employee"() {
        expect:
        new TechnicalLead("RogerFederer").level == 5
    }

    def "project manager is level 10 employee"() {
        expect:
        new ProjectManager("RafaelNadal").level == 10
    }

    def "boss is level 100, and he has a powerful solution"() {
        given:
        def boss = new Boss("Djoko")

        expect:
        assert boss.level == 100
        assert boss.solution instanceof AllFreeSolution
    }

    def "boss is always free"() {
        given:
        def boss = new Boss("Djoko")

        when:
        boss.free = false

        then:
        boss.free
    }

}
