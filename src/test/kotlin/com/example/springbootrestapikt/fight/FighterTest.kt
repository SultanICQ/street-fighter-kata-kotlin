package com.example.springbootrestapikt.fight

import com.example.springbootrestapikt.fight.stats.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito

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

    @Test
    fun shouldEvadeAttack() {
        val attackDice: IDice = Mockito.mock(IDice::class.java)
        val criticDice: IDice = Mockito.mock(IDice::class.java)
        val evasionDice: IDice = Mockito.mock(IDice::class.java)
        Mockito.`when`(attackDice.roll()).thenReturn(5)
        Mockito.`when`(criticDice.roll()).thenReturn(35)
        Mockito.`when`(evasionDice.roll()).thenReturn(1)
        Assertions.assertEquals(attackDice.roll(), 5)
        val attacker = Fighter(Strength(Stat(9), attackDice), Dexterity.new(9), Luck(Stat(9), criticDice), Vitality.new(2), Defense.new(1), Health(200))
        val defender = Fighter(Strength.new(9), Dexterity(Stat(9), evasionDice), Luck.new(1), Vitality.new(2), Defense.new(9), Health(200))
        val newDefender = attacker.attack(defender)
        Assertions.assertEquals(newDefender.health.value, 200)
    }

    @Test
    fun shouldReceiveDamage() {
        val attackDice: IDice = Mockito.mock(IDice::class.java)
        val criticDice: IDice = Mockito.mock(IDice::class.java)
        val evasionDice: IDice = Mockito.mock(IDice::class.java)
        val defenseDice: IDice = Mockito.mock(IDice::class.java)
        Mockito.`when`(attackDice.roll()).thenReturn(5)
        Mockito.`when`(criticDice.roll()).thenReturn(35)
        Mockito.`when`(evasionDice.roll()).thenReturn(100)
        Mockito.`when`(defenseDice.roll()).thenReturn(5)
        val attacker = Fighter(Strength(Stat(9), attackDice), Dexterity.new(9), Luck(Stat(9), criticDice), Vitality.new(2), Defense.new(1), Health(200))
        val defender = Fighter(Strength.new(9), Dexterity(Stat(9), evasionDice), Luck.new(1), Vitality.new(2), Defense(Stat(9), defenseDice), Health(200))
        val newDefender = attacker.attack(defender)
        Assertions.assertEquals(newDefender.health.value, 178)
    }




}
