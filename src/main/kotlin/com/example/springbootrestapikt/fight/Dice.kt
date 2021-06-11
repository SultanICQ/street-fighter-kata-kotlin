package com.example.springbootrestapikt.fight

import kotlin.random.Random
interface IDice {
    fun roll() : Int
}
data class Dice (val faces: Int) : IDice {
    override fun roll () = Random.nextInt(1, faces)
}