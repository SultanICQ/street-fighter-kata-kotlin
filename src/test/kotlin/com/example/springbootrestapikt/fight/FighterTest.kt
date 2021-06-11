package com.example.springbootrestapikt.fight

import com.example.springbootrestapikt.fight.stats.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FighterTest {
    @Test
    fun shouldWorkWithStatSumEquals30() {
        Fighter.new(9,9,9,2,1)
    }

    @Test
    fun shouldNotWorkWithStateValueDifferentOf1to10Range() {
        assertThrows<InvalidFighter> { Fighter.new(9,9,9,2,10) }
        assertThrows<InvalidFighter> { Fighter.new(2,2,2,2,1) }
    }

    @Test
    fun shouldGetStrengthBetween5and25 () {
        Fighter.createTank()
    }


}
