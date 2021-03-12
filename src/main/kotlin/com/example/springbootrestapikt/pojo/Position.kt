package com.example.springbootrestapikt.pojo

class Position(private val vertical: Int, private val horizontal: Int) {
    fun addVertically(number: Int): Position {
        return Position(this.vertical + number, this.horizontal)
    }

    fun addHorizontally(number: Int): Position {
        return Position (this.vertical, this.horizontal+number)
    }
}