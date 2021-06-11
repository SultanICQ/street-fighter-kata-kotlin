package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Dice
import com.example.springbootrestapikt.fight.IDice
import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Strength(override val stat: Stat, val dice: IDice) : Trait {
    companion object {
        fun new (value: Int) = Strength(Stat(value), Dice(5))
    }
    fun rollDamage () = dice.roll() * stat.value
}
