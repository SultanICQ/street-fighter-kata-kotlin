package com.example.springbootrestapikt.fight

import com.example.springbootrestapikt.fight.stats.*

class InvalidFighter: RuntimeException("Invalid fighter")

data class Fighter(private val str: Strength, private val dex: Stat, private val luck: Stat, private val vit: Stat, private val def: Stat) {
    companion object {
        fun createTank() {
            Fighter(Strength(5), Dexterity(2), Luck(3), Vitality(10), Defense(10))
        }

        fun createAssassin() {
            Fighter(Strength(9), Dexterity(9), Luck(9), Vitality(2), Defense(1))
        }

        fun createKnight() {
            Fighter(Strength(6), Dexterity(6), Luck(6), Vitality(6), Defense(6))
        }
    }

    init {
        if (str.value + dex.value + luck.value + vit.value + def.value != 30) {
            throw InvalidFighter()
        }
    }

    fun attack (stat: Int): Boolean { return stat in 1..10 }


}
