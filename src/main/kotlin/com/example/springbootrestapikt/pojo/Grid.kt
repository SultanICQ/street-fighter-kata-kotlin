package com.example.springbootrestapikt.pojo

class Grid(val fighters: Array<Array<String>>, var position: Position, var history: List<Cell> = ArrayList()) {

    var cells : List<Cell> = fighters.mapIndexed { verticalPos, row ->
        row.mapIndexed { horizontalPos, fighterName -> Cell(Fighter(fighterName), Position(verticalPos, horizontalPos))}
    }.flatten()

    fun move(move: Position): Grid {
        this.position = Position(position.vertical + move.vertical, position.horizontal+move.horizontal)
        val newCell = cells.find { cell: Cell -> this.position.isEqual(cell.position) }
        if (newCell != null) history += listOf(newCell)
        return Grid(fighters, position, history)
    }

    fun getResult(): List<String> {
        return history.map { cell: Cell -> cell.fighter.name }
    }

}
