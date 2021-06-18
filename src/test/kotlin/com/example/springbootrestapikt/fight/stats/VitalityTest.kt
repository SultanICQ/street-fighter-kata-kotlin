package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Health
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VitalityTest {
    @Test
    fun shouldWorkWithStateValueBetween1and10() {

    }

    @Test
    fun shouldReturnMaxHealthValue() {
        Assertions.assertEquals(Vitality.new(5).maxHealth(), Health(500))
    }
}

