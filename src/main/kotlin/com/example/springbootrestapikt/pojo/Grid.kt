package com.example.springbootrestapikt.pojo

import java.util.*
import kotlin.collections.ArrayList

data class Grid(val cells: List<Cell>, val currentCell: Cell, val history: List<Cell> = emptyList()) {

    fun move(move: Position): Grid {
        var newPosition = currentCell.position.sum(move)
        var finalCell = currentCell
        if(move.vertical == -1){
            var newCells = cells.filter { cell: Cell -> cell.position.horizontal == currentCell.position.horizontal }
            var upCells = newCells.filter { cell: Cell -> cell.position.vertical < currentCell.position.vertical }
            if(upCells.isEmpty() || upCells.last().fighter.name.isEmpty()){
                finalCell = currentCell
            }else{
                finalCell = upCells.last()
            }
        }
        else if(move.vertical == 1){
            var newCells = cells.filter { cell: Cell -> cell.position.horizontal == currentCell.position.horizontal }
            var downCells = newCells.filter { cell: Cell -> cell.position.vertical > currentCell.position.vertical }
            if(downCells.isEmpty() || downCells.first().fighter.name.isEmpty()){
                finalCell = currentCell
            }else{
                finalCell = downCells.first()
            }
        }
        else if(move.horizontal == -1){
            var newCells = cells.filter { cell: Cell -> cell.position.vertical == currentCell.position.vertical }
            var leftCells = newCells.filter { cell: Cell -> cell.position.horizontal < currentCell.position.horizontal && cell.fighter.name != ""}
            var rightCells = newCells.filter { cell: Cell -> cell.position.horizontal > currentCell.position.horizontal && cell.fighter.name != ""}
            var newCellsDos = rightCells + leftCells
            finalCell = newCellsDos.reversed().first()

        }
        else if(move.horizontal == 1){
            var newCells = cells.filter { cell: Cell -> cell.position.vertical == currentCell.position.vertical }
            var leftCells = newCells.filter { cell: Cell -> cell.position.horizontal < currentCell.position.horizontal && cell.fighter.name != ""}
            var rightCells = newCells.filter { cell: Cell -> cell.position.horizontal > currentCell.position.horizontal && cell.fighter.name != ""}
            var newCellsDos = rightCells + leftCells
            finalCell = newCellsDos.first()


        }

        return copy( history = history + finalCell, currentCell = finalCell)
    }

    fun getResult(): List<String> {
        return history.map { cell: Cell -> cell.fighter.name }
    }

    companion object {
        fun create (fighters: Array<Array<String>>, position: Position, history: List<Cell> = emptyList()): Grid {
            val cells : List<Cell> = fighters.mapIndexed { verticalPos, row ->
                row.mapIndexed { horizontalPos, fighterName -> Cell(Fighter(fighterName), Position(verticalPos, horizontalPos))}
            }.flatten()

            val currentCell = Optional.ofNullable( cells.find { cell: Cell -> position.isEqual(cell.position) }).orElseGet{ throw RuntimeException()}
            return Grid(cells, currentCell )
        }
    }
}
