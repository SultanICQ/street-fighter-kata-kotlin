package com.example.springbootrestapikt.pojo

enum class Movement {
    UP ,
    DOWN ,
    LEFT ,
    RIGHT ;

}
fun String.asMovement() = Movement.valueOf(this.toUpperCase())
