package com.gr.android.trilhaventurus_ex10.math

import org.junit.Assert
import org.junit.Test

internal class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `test when sum 2 + 2 then returns 4`() {
        val expected = 4
        val result = calculator.sum(2, 2)
        Assert.assertEquals(expected, result)
    }
}