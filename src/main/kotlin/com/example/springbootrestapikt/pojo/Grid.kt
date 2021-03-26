package com.example.springbootrestapikt.pojo

class Grid(val fighters: Array<Array<String>>, val position: Position) {

    var cells : List<Cell> = fighters.mapIndexed { verticalPos, row ->
        row.mapIndexed { horizontalPos, fighterName -> Cell(fighterName, Position(verticalPos, horizontalPos))}
    }.flatMapTo(ArrayList()) {it -> it}

    fun move(): List<Cell> {
        return cells
    }

}

