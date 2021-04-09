package com.example.springbootrestapikt.pojo

class Directions(private val up: Position = Position(-1, 0),
                 private val down: Position = Position(1, 0),
                 private val left: Position = Position(0, -1),
                 private val right: Position = Position(0, 1)
) {
    public fun getDirection(move: String): Position {
        when (move) {
            "up" ->
                return this.up
            "down" ->
                return this.down
            "left" ->
                return this.left
            "right" ->
                return this.right
        }

        return Position(0,0)
    }

}
