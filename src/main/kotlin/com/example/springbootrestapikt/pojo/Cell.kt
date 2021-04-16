package com.example.springbootrestapikt.pojo

class Cell(val fighter: Fighter, val position: Position) {

}

fun List<Cell>.rowOf(cell: Cell) = this.filter { it.position.vertical == cell.position.vertical }
fun List<Cell>.columnOf(cell: Cell) = this.filter { it.position.horizontal == cell.position.horizontal }
