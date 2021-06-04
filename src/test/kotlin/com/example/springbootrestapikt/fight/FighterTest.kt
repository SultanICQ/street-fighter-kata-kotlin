package com.example.springbootrestapikt.fight

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FighterTest {
    @Test
    fun shouldWorkWithStatSumEquals30() {
        Fighter(Stat(9), Stat(9), Stat(9), Stat(2), Stat(1))
    }

    @Test
    fun shouldNotWorkWithStateValueDifferentOf1to10Range() {
        assertThrows<InvalidFighter> { Fighter(Stat(9), Stat(9), Stat(9), Stat(2), Stat(10)) }
        assertThrows<InvalidFighter> { Fighter(Stat(2), Stat(2), Stat(2), Stat(2), Stat(1)) }
    }

    @Test
    fun shouldGetStrengthBetween5and25 () {
        assertThrows<InvalidFighter> { Fighter(Stat(9), Stat(9), Stat(9), Stat(2), Stat(10)) }
    }


}
