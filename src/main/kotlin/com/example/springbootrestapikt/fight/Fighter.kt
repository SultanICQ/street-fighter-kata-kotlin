package com.example.springbootrestapikt.fight

import com.example.springbootrestapikt.fight.stats.*
import java.util.*
import kotlin.random.Random

class InvalidFighter: RuntimeException("Invalid fighter")

data class Fighter(private val str: Strength, private val dex: Dexterity, private val luck: Luck, private val vit: Vitality, private val def: Defense) {
    companion object {
        fun new(str: Int, dex: Int, lck: Int, vit: Int, def: Int) = Fighter(Strength.new(str), Dexterity.new(dex), Luck.new(lck), Vitality.new(vit), Defense.new(def))

        fun createTank() = new(5,2,3,10,10)

        fun createAssassin() = new(9,9,9,2,1)

        fun createKnight() = new(6,6,6,6,6)

    }

    init {
        if (str.value + dex.value + luck.value + vit.value + def.value != 30) {
            throw InvalidFighter()
        }
    }

    fun attack (): Int {
        val dmg = str.rollDamage()
        if(luck.rollCritic()) return (dmg * 1.5).toInt()
        return dmg
    }


}
