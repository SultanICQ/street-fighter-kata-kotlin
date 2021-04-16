package com.example.springbootrestapikt.pojo

object Solution {
    private var currentPos: Position = Position(0, 0)
    private var fighters: Array<Array<String>> = emptyArray()

    fun superStreetFighterize(fighters: Array<Array<String>>, position: IntArray, moves: Array<String>): Array<String> {
        if (moves.size == 0) {
            return arrayOf()
        }

        val grid = Grid.create(fighters, Position(position[0], position[1]) )

        currentPos = Position(position[0], position[1])
        this.fighters = fighters

        val result = moves.fold(grid, { acc: Grid, move: String ->
            acc.move(Directions().getDirection(move))
        })

        return result.getResult().toTypedArray()
    }
}
