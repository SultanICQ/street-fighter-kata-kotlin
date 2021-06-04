package com.example.springbootrestapikt.fight

import java.lang.Exception

class InvalidStat: RuntimeException("Invalid stat")

data class Stat(val value: Int) {
    private fun checkValidStat (stat: Int): Boolean { return stat in 1..10 }

    init {
        if (!checkValidStat(value)) {
            throw InvalidStat()
        }
    }
}
