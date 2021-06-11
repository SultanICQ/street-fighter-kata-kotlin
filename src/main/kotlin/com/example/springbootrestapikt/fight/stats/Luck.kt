package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Dice
import com.example.springbootrestapikt.fight.IDice
import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Luck(override val stat: Stat, val dice: IDice) : Trait {
    companion object {
        fun new (value: Int) = Luck(Stat(value), Dice(100))
    }
    fun rollCritic () = dice.roll() < stat.value * 5
}

