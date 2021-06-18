package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.IDice
import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.stats.Strength
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class DexterityTest {
    @Test
    fun shouldWorkWithStateValueBetween1and10() {
        Dexterity.new(5)
    }

    @Test
    fun shouldReturnEvasionTrue() {
        val dexterityDice : IDice = Mockito.mock(IDice::class.java)
        Mockito.`when`(dexterityDice.roll()).thenReturn(24)
        val dex = Dexterity(Stat(5), dexterityDice)
        Assertions.assertTrue(dex.rollEvasion())
    }

    @Test
    fun shouldReturnEvasionFalse() {
        val dexterityDice : IDice = Mockito.mock(IDice::class.java)
        Mockito.`when`(dexterityDice.roll()).thenReturn(25)
        val dex = Dexterity(Stat(5), dexterityDice)
        Assertions.assertFalse(dex.rollEvasion())
    }
}

