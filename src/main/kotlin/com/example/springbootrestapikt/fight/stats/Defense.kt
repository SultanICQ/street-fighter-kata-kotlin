package com.example.springbootrestapikt.fight.stats

import com.example.springbootrestapikt.fight.Stat

data class Defense(val stat: Stat) {
    val value = stat.value
    companion object {
        fun new (value: Int) = Defense(Stat(value))
    }
}
