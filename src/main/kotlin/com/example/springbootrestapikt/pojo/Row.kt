package com.example.springbootrestapikt.pojo

class Row (val rowIndex:Int, val sourceFighters: Array<String>) {

    val fighters: List<Fighter> = sourceFighters.mapIndexed{ idx, value ->
        Fighter(value, Position(rowIndex, idx))
    }

}