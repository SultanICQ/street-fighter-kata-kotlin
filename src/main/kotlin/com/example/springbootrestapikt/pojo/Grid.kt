package com.example.springbootrestapikt.pojo

import java.util.*
import kotlin.collections.ArrayList

data class Grid(val cells: List<Cell>, val currentCell: Cell, val history: List<Cell> = emptyList()) {

    fun move(move: Movement): Grid {
        when (move) {
            Movement.UP -> {
                val newCells = cells.columnOf(currentCell)
                val upCells = newCells.filter { cell: Cell -> cell.position.vertical < currentCell.position.vertical }
                if (upCells.isEmpty() || upCells.last().fighter.name.isEmpty()) {
                    return copy(history = history + currentCell)
                } else {
                    return copy(history = history + upCells.last(), currentCell = upCells.last())
                }
            }
            Movement.DOWN -> {
                val newCells = cells.columnOf(currentCell)
                val downCells = newCells.filter { cell: Cell -> cell.position.vertical > currentCell.position.vertical }
                if (downCells.isEmpty() || downCells.first().fighter.name.isEmpty()) {
                    return copy(history = history + currentCell)
                } else {
                    return copy(history = history + downCells.first(), currentCell = downCells.first())
                }
            }
            Movement.LEFT -> {
                val newCells = cells.rowOf(currentCell)
                val leftCells =
                    newCells.filter { cell: Cell -> cell.position.horizontal < currentCell.position.horizontal && cell.fighter.name != "" }
                val rightCells =
                    newCells.filter { cell: Cell -> cell.position.horizontal > currentCell.position.horizontal && cell.fighter.name != "" }
                val newCellsDos = rightCells + leftCells
                return copy(
                    history = history + newCellsDos.reversed().first(),
                    currentCell = newCellsDos.reversed().first()
                )
            }
            Movement.RIGHT -> {
                val newCells = cells.rowOf(currentCell)
                val leftCells =
                    newCells.filter { cell: Cell -> cell.position.horizontal < currentCell.position.horizontal && cell.fighter.name != "" }
                val rightCells =
                    newCells.filter { cell: Cell -> cell.position.horizontal > currentCell.position.horizontal && cell.fighter.name != "" }
                val newCellsDos = rightCells + leftCells
                return copy(history = history + newCellsDos.first(), currentCell = newCellsDos.first())
            }
        }
    }

    fun getResult(): List<String> {
        return history.map { cell: Cell -> cell.fighter.name }
    }

    companion object {
        fun create(fighters: Array<Array<String>>, position: Position, history: List<Cell> = emptyList()): Grid {
            val cells: List<Cell> = fighters.mapIndexed { verticalPos, row ->
                row.mapIndexed { horizontalPos, fighterName ->
                    Cell(
                        Fighter(fighterName),
                        Position(verticalPos, horizontalPos)
                    )
                }
            }.flatten()

            val currentCell = Optional.ofNullable(cells.find { cell: Cell -> position.isEqual(cell.position) })
                .orElseGet { throw RuntimeException() }
            return Grid(cells, currentCell)
        }
    }
}
