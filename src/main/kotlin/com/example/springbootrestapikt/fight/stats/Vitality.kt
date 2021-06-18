package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Health
import com.example.springbootrestapikt.fight.Stat
import com.example.springbootrestapikt.fight.Trait

data class Vitality(override val stat: Stat) : Trait {
    companion object {
        fun new (value: Int) = Vitality(Stat(value))
    }
    fun maxHealth () = Health(stat.value * 100)
}
