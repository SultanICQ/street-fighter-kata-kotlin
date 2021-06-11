package com.example.springbootrestapikt.fight

interface Trait {
    val stat: Stat
    val value: Int
        get() = stat.value
}