package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Dice
import com.example.springbootrestapikt.fight.IDice
import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Dexterity(override val stat: Stat, val dice: IDice) : Trait {
    companion object {
        fun new (value: Int) = Dexterity(Stat(value), Dice(100))
    }
    fun rollEvasion () = dice.roll() < 5 * stat.value
}
