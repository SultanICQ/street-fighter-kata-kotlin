package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Dice
import com.example.springbootrestapikt.fight.Fighter
import com.example.springbootrestapikt.fight.IDice
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class StrengthTest {


    @Test
    fun shouldWorkWithStateValueBetween1and10() {
        Strength.new(5)
    }

    @Test
    fun shouldReturnValidAttackValue() {
        val diceMock: IDice = mock(IDice::class.java)
        `when`(diceMock.roll()).thenReturn(5)
        assertEquals(diceMock.roll(), 5)
        assertEquals(Fighter.createAssassin().attack(diceMock), 45)
        assertEquals(Fighter.createKnight().attack(diceMock), 30)
    }
}

