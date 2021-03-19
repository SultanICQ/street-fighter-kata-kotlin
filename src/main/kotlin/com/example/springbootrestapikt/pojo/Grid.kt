package com.example.springbootrestapikt.pojo

class Grid(val fighters: Array<Array<String>>, val position: Position) {

    var rows : List<Row> = fighters.mapIndexed { idx, value ->
        Row(idx, value)
    }

    fun move() {

    }

}