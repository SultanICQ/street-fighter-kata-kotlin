package com.example.springbootrestapikt.pojo

object Solution {
    private var currentPos: Position = Position(0, 0)
    private var fighters: Array<Array<String>> = emptyArray()

    fun superStreetFighterize(fighters: Array<Array<String>>, position: IntArray, moves: Array<String>): Array<String>? {
        if (moves.size == 0) {
            return arrayOf()
        }

        currentPos = Position(position[0], position[1])
        this.fighters = fighters

        val result = moves.fold(emptyArray(), { acc: Array<String>, move: String ->
            acc + checkFighter(nextPosition(move))
        })

        return result
    }

    fun nextPosition(move: String): Position {
        val pos = Directions().getDirection(move)

        var tmp = currentPos.addHorizontally(pos.horizontal).addVertically(pos.vertical)
        if (tmp.horizontal < 0) {
            tmp = Position(tmp.vertical, fighters[tmp.vertical].size - 1)
        }
        if (tmp.horizontal >= fighters[tmp.vertical].size) {
            tmp = Position(tmp.vertical, 0)
        }
        currentPos = tmp

        if (checkFighter(currentPos) == "") {
            currentPos = nextPosition(move)
        }
        return currentPos
    }

    fun checkFighter(position: Position): String {
        return fighters[position.vertical][position.horizontal]
    }
}