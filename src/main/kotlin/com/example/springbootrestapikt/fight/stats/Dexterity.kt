package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Stat

data class Dexterity(val stat: Stat) {
    val value = stat.value
    companion object {
        fun new (value: Int) = Dexterity(Stat(value))
    }
}
