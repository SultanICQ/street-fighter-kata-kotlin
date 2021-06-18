package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Fighter
import com.example.springbootrestapikt.fight.IDice
import com.example.springbootrestapikt.fight.Stat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class StrengthTest {


    @Test
    fun shouldWorkWithStateValueBetween1and10() {
        Strength.new(5)
    }


}

