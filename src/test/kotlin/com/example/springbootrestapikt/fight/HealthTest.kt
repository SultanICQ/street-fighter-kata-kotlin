package com.example.springbootrestapikt.fight

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class HealthTest {
    @Test
    fun shouldReduceHealth() {
        val health = Health(100)
        val newHealth = health.reduce(50)
        Assertions.assertEquals(newHealth.value, 50)
    }

    @Test
    fun shouldReduceAllHealth() {
        val health = Health(100)
        val newHealth = health.reduce(101)
        Assertions.assertEquals(newHealth.value, 0)
    }
}
