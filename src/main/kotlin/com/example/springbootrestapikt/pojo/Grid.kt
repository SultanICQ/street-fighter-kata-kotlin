package com.example.springbootrestapikt.pojo

class Grid(val fighters: Array<Array<String>>, var position: Position) {

    var history: List<Cell> = ArrayList()

    var cells : List<Cell> = fighters.mapIndexed { verticalPos, row ->
        row.mapIndexed { horizontalPos, fighterName -> Cell(Fighter(fighterName), Position(verticalPos, horizontalPos))}
    }.flatMapTo(ArrayList()) {it -> it}

    fun move(move: Position): Cell? {
        this.position = Position(position.vertical + move.vertical, position.horizontal+move.horizontal)
        return cells.find { cell: Cell -> this.position.isEqual(cell.position) }
    }

    fun getResult(): List<String> {
        return history.map { cell: Cell -> cell.fighter.name }
    }

}
