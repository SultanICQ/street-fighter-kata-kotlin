package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Strength(override val stat: Stat) : Trait {
    companion object {
        fun new (value: Int) = Strength(Stat(value))
    }
}
