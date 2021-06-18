package com.example.springbootrestapikt.fight

import com.example.springbootrestapikt.fight.stats.Vitality

data class Health(val value : Int) {
    fun reduce (damage : Int) : Health {
        if(damage >= value) return Health(0)
        return Health(value - damage)
    }
}