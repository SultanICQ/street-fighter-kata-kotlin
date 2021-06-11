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

    @Test
    fun shouldReturnValidAttackValue() {
        val attackDice: IDice = mock(IDice::class.java)
        val criticDice: IDice = mock(IDice::class.java)
        `when`(attackDice.roll()).thenReturn(5)
        `when`(criticDice.roll()).thenReturn(35)
        assertEquals(attackDice.roll(), 5)
        val assasin = Fighter(Strength(Stat(9), attackDice), Dexterity.new(9), Luck(Stat(9), criticDice), Vitality.new(2), Defense.new(1))
        assertEquals(assasin.attack(), (45 * 1.5).toInt())
        //assertEquals(Fighter.createKnight().attack(), 30)
    }
}

