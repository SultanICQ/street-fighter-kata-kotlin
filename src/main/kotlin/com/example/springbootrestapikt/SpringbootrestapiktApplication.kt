package com.example.springbootrestapikt

import com.example.springbootrestapikt.pojo.Solution
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootrestapiktApplication
var fighters = arrayOf(
        arrayOf("", "Ryu", "E.Honda", "Blanka", "Guile", ""),
        arrayOf("Balrog", "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat"),
        arrayOf("Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy", "M.Bison"))

fun main(args: Array<String>) {
    runApplication<SpringbootrestapiktApplication>(*args)
    Solution.superStreetFighterize(fighters, intArrayOf(0, 1), arrayOf("up", "left", "right", "left", "left"))
}
