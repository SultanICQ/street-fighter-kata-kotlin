package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Luck(override val stat: Stat) : Trait {
    companion object {
        fun new (value: Int) = Luck(Stat(value))
    }
}

