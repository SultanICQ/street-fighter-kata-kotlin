package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Dice
import com.example.springbootrestapikt.fight.IDice
import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Defense(override val stat: Stat, val dice: IDice) : Trait {
    companion object {
        fun new (value: Int) = Defense(Stat(value), Dice(5))
    }
    fun rollDefense() = dice.roll() * stat.value
}
