package com.example.springbootrestapikt.fight

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class StatTest {
    @Test
    fun shouldWorkWithStateValueBetween1and10() {
        Stat(5)
    }

    @Test
    fun shouldNotWorkWithStateValueDifferentOf1to10Range() {
        assertThrows<InvalidStat> { Stat(0) }
        assertThrows<InvalidStat> { Stat(11) }
    }
}
