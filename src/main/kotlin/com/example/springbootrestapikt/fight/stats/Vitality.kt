package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Stat

data class Vitality(val stat: Stat) {
    val value = stat.value
    companion object {
        fun new (value: Int) = Vitality(Stat(value))
    }
}
