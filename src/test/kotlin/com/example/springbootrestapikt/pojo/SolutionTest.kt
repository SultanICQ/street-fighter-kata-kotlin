package com.example.springbootrestapikt.pojo

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test


class SolutionTest {
    var fighters = arrayOf(
            arrayOf("", "Ryu", "E.Honda", "Blanka", "Guile", ""),
            arrayOf("Balrog", "Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat"),
            arrayOf("Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy", "M.Bison"))

    @Test
    fun shouldWorkWithNoMoves() {
        val solution = arrayOf<String>()
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, intArrayOf(0, 1), arrayOf<String>()))
    }

    @Test
    fun shouldWorkWithFewMoves() {
        val moves = arrayOf("up", "left", "right", "left", "left")
        val position = intArrayOf(1, 1)
        val solution = arrayOf("Ryu", "Guile", "Ryu", "Guile", "Blanka")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldStopOnEmptySpacesVertically() {
        val moves = arrayOf("up")
        val position = intArrayOf(1, 0)
        val solution = arrayOf("Balrog")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldStopOnEmptySpacesVertically2() {
        val moves = arrayOf("up", "up", "up", "up")
        val position = intArrayOf(1, 0)
        val solution = arrayOf("Balrog", "Balrog", "Balrog", "Balrog")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldStopVertically() {
        val moves = arrayOf("down", "down", "down", "down")
        val position = intArrayOf(1, 0)
        val solution = arrayOf("Vega", "Vega", "Vega", "Vega")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldStopOnEmptySpacesVertically3() {
        val moves = arrayOf("up", "up", "up", "up")
        val position = intArrayOf(1, 5)
        val solution = arrayOf("Sagat", "Sagat", "Sagat", "Sagat")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldStopVertically4() {
        val moves = arrayOf("down", "down", "down", "down")
        val position = intArrayOf(1, 5)
        val solution = arrayOf("M.Bison", "M.Bison", "M.Bison", "M.Bison")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldRotateHorizontallyWithEmptySpaces() {
        val moves = arrayOf("right", "right", "right", "right", "right", "right", "right", "right")
        val position = intArrayOf(0, 2)
        val solution = arrayOf("Blanka", "Guile", "Ryu", "E.Honda", "Blanka", "Guile", "Ryu", "E.Honda")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldRotateHorizontally() {
        val moves = arrayOf("left", "left", "left", "left", "left", "left", "left", "left")
        val position = intArrayOf(1, 3)
        val solution = arrayOf("Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Chun Li", "Ken")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    @Test
    fun shouldRotateOnAllRows() {
        val moves = arrayOf("right", "right", "right", "right", "right", "right", "down", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "down", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right")
        val position = intArrayOf(0, 2)
        val solution = arrayOf("Blanka", "Guile", "Ryu", "E.Honda", "Blanka", "Guile", "Dhalsim", "Zangief", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Cammy", "M.Bison", "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy", "M.Bison", "Vega", "T.Hawk", "Fei Long", "Deejay", "Cammy")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters, position, moves))
    }

    // DO NOT CHANGE THIS VARIABLE!
    // LIST WITH HOLES AND DUPLICATES
    var fighters3 = arrayOf(arrayOf("", "Ryu", "E.Honda", "Cammy", "Blanka", "Guile", "", "Chun Li"), arrayOf("Balrog", "Ken", "Chun Li", "", "M.Bison", "Zangief", "Dhalsim", "Sagat"), arrayOf("Vega", "", "Fei Long", "Balrog", "Deejay", "Cammy", "", "T.Hawk"))
    @Test
    fun shouldRotateOnAllRows3() {
        val moves = arrayOf("right", "right", "right", "right", "right", "right", "down", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "left", "down", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right", "right")
        val position = intArrayOf(0, 2)
        val solution = arrayOf("Cammy", "Blanka", "Guile", "Chun Li", "Ryu", "E.Honda", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "M.Bison", "Chun Li", "Ken", "Balrog", "Sagat", "Dhalsim", "Zangief", "Cammy", "T.Hawk", "Vega", "Fei Long", "Balrog", "Deejay", "Cammy", "T.Hawk", "Vega", "Fei Long", "Balrog", "Deejay", "Cammy")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters3, position, moves))
    }

    @Test
    fun shouldJustWork3() {
        val moves = arrayOf("down", "right", "right", "right", "down", "left", "left", "down", "right", "right", "right", "up")
        val position = intArrayOf(0, 3)
        val solution = arrayOf("Cammy", "Blanka", "Guile", "Chun Li", "Sagat", "Dhalsim", "Zangief", "Cammy", "T.Hawk", "Vega", "Fei Long", "Chun Li")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters3, position, moves))
    }

    var fighters4 = arrayOf(arrayOf("", "Ryu", "E.Honda", "Cammy"), arrayOf("Balrog", "Ken", "Chun Li", ""), arrayOf("Vega", "", "Fei Long", "Balrog"), arrayOf("Blanka", "Guile", "", "Chun Li"), arrayOf("M.Bison", "Zangief", "Dhalsim", "Sagat"), arrayOf("Deejay", "Cammy", "", "T.Hawk"))
    @Test
    fun shouldWorkWithLongerGrid4() {
        val moves = arrayOf("left", "left", "down", "right", "right", "right", "right", "down", "left", "left", "left", "left", "down", "right", "right", "down", "right", "right", "right", "down", "left", "left", "left", "down", "left", "left", "left")
        val position = intArrayOf(0, 3)
        val solution = arrayOf("E.Honda", "Ryu", "Ken", "Chun Li", "Balrog", "Ken", "Chun Li", "Fei Long", "Vega", "Balrog", "Fei Long", "Vega", "Blanka", "Guile", "Chun Li", "Sagat", "M.Bison", "Zangief", "Dhalsim", "Dhalsim", "Zangief", "M.Bison", "Sagat", "T.Hawk", "Cammy", "Deejay", "T.Hawk")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters4, position, moves))
    }

    @Test
    fun shouldWorkWithOddInitialPosition() {
        val moves = arrayOf("left", "left", "down", "right", "right", "right", "right", "down", "left", "left", "left", "left", "up", "right", "right", "up", "right", "right", "right")
        val position = intArrayOf(3, 3)
        val solution = arrayOf("Guile", "Blanka", "M.Bison", "Zangief", "Dhalsim", "Sagat", "M.Bison", "Deejay", "T.Hawk", "Cammy", "Deejay", "T.Hawk", "Sagat", "M.Bison", "Zangief", "Guile", "Chun Li", "Blanka", "Guile")
        assertArrayEquals(solution, Solution.superStreetFighterize(fighters4, position, moves))
    }
}