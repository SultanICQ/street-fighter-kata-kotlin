package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.stats.Strength
import org.junit.jupiter.api.Test

class StrengthTest {
    @Test
    fun shouldWorkWithStateValueBetween1and10() {
        Strength.new(5)
    }
}

