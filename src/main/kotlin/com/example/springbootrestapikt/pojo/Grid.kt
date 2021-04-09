package com.example.springbootrestapikt.pojo

import java.util.*
import kotlin.collections.ArrayList

data class Grid(val cells: List<Cell>, val currentCell: Cell, val history: List<Cell> = emptyList()) {

    fun move(move: Position): Grid {
        val newPosition = currentCell.position.sum(move)
        //val newCell = getNextCell(newPosition, move)
        return Optional.ofNullable(cells.find { cell: Cell -> newPosition.isEqual(cell.position) })
                .map { copy( currentCell = it, history = history + listOf(it)) }
                .orElseGet{ copy(history = history + currentCell) }
    }

//    private fun getNextCell(newPosition: Position, move: Position): Cell {
//        val newCell = cells.find { cell: Cell -> newPosition.isEqual(cell.position) && cell.fighter.name != "" }
//                ?: getNextCell(newPosition.sum(move))
//        return newCell
//    }

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
