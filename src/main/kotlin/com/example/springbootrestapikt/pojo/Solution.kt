package com.example.springbootrestapikt.pojo

object Solution {
    private var currentPos: Position = Position(0, 0)
    private var fighters: Array<Array<String>> = emptyArray()

    fun superStreetFighterizeOld(fighters: Array<Array<String>>, position: IntArray, moves: Array<String>): Array<String>? {
        if (moves.size == 0) {
            return arrayOf()
        }

        val result2 = moves.fold(emptyArray(), { acc: Array<String>, move: String ->
            acc + checkFighter(nextPosition(move))
        })

        currentPos = Position(position[0], position[1])
        this.fighters = fighters

        val result = moves.fold(emptyArray(), { acc: Array<String>, move: String ->
            acc + checkFighter(nextPosition(move))
        })

        if ( result.equals(result2) ) {
            return result2
        }

        return result
    }

    fun superStreetFighterize(fighters: Array<Array<String>>, position: IntArray, moves: Array<String>): List<String> {
        if (moves.size == 0) {
            return listOf()
        }

        val grid = Grid(fighters, Position(position[0], position[1]) )
        val nextCell = grid.move(Directions().getDirection("down"))

        currentPos = Position(position[0], position[1])
        this.fighters = fighters


        val result = moves.fold(grid, { acc: Grid, move: String ->
            grid.move(Directions().getDirection(move))
        })

        return result.getResult()
    }

    fun nextPosition(move: String): Position {
        val pos = Directions().getDirection(move)

        var tmp = currentPos.addHorizontally(pos.horizontal).addVertically(pos.vertical)
        if (tmp.horizontal < 0) {
            tmp = Position(tmp.vertical, fighters[tmp.vertical].size - 1)
        }
        if (tmp.vertical< fighters.size && tmp.horizontal >= fighters[tmp.vertical].size) {
            tmp = Position(tmp.vertical, 0)
        }

        if (tmp.vertical < 0 ) { tmp = currentPos; }
        if (tmp.vertical >= fighters.size ) { tmp = currentPos; }
        if (pos.vertical!=0 && checkFighter(tmp) == "" ) {
            tmp = currentPos
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
