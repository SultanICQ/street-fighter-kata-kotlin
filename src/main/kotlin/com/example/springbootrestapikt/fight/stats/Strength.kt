package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Stat

data class Strength(val stat: Stat) {
    val value = stat.value
    companion object {
        fun new (value: Int) = Strength(Stat(value))
    }
}
