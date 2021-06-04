package com.example.springbootrestapikt.fight

class InvalidFighter: RuntimeException("Invalid fighter")

data class Fighter(private val str: Stat, private val dex: Stat, private val luck: Stat, private val vit: Stat, private val def: Stat) {
    companion object {
        fun createTank() {
            Fighter(Stat(5), Stat(2), Stat(3), Stat(10), Stat(10))
        }

        fun createAssassin() {
            Fighter(Stat(9), Stat(9), Stat(9), Stat(2), Stat(1))
        }

        fun createKnight() {
            Fighter(Stat(6), Stat(6), Stat(6), Stat(6), Stat(6))
        }
    }

    init {
        if (str.value + dex.value + luck.value + vit.value + def.value != 30) {
            throw InvalidFighter()
        }
    }

    fun attack (stat: Int): Boolean { return stat in 1..10 }

//    fun dices (min: Int, max: Int): Int {
//        val randomValues = List(10) { Random.nextInt(min, max) }
//    }
}
