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

    @Test
    fun `test when sum -2 + -2 then returns -4`() {
        val expected = -4
        val result = calculator.sum(-2, -2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when subtraction -2 - -2 then returns 0`() {
        val expected = 0
        val result = calculator.subtraction(-2, -2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when subtraction 2 - 2 then returns 0`() {
        val expected = 0
        val result = calculator.subtraction(2, 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when subtraction 0 - 2 then returns -2`() {
        val expected = -2
        val result = calculator.subtraction(0, 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when multiplication 0 x 2 then returns 0`() {
        val expected = 0
        val result = calculator.multiplication(0, 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when multiplication -1 x 2 then returns -2`() {
        val expected = -2
        val result = calculator.multiplication(-1, 2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when multiplication -1 x -2 then returns 2`() {
        val expected = 2
        val result = calculator.multiplication(-1, -2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test when division 2 by 2 then returns 1`() {
        val expected = 1.0
        val result = calculator.division(2, 2)
        Assert.assertEquals(expected, result, 0.5)
    }

    @Test
    fun `test when division 2 by 0 returns error`() {
        val expected = 0.0
        val result = calculator.division(2, 0)
        Assert.assertEquals(expected, result, 0.5)
    }

    @Test
    fun `test when division 10 by -1 returns -10`() {
        val expected = -10.0
        val result = calculator.division(10, -1)
        Assert.assertEquals(expected, result, 0.5)
    }

    @Test
    fun `test when division -1 by -1 returns 1`() {
        val expected = 1.0
        val result = calculator.division(-1, -1)
        Assert.assertEquals(expected, result, 0.5)
    }

    @Test
    fun `test if 2 is pair`() {
        val expected = true
        val result = calculator.isPair(2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test if -2 is pair`() {
        val expected = true
        val result = calculator.isPair(-2)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test if 0 is pair`() {
        val expected = true
        val result = calculator.isPair(0)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test if 10 is pair`() {
        val expected = true
        val result = calculator.isPair(10)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test if 3 is pair`() {
        val expected = false
        val result = calculator.isPair(3)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `test 10 power 1`() {
        val expected = 10.0
        val result = calculator.power(10.0, 1.0)
        Assert.assertEquals(expected, result, 0.01)
    }

    @Test
    fun `test 10 power 2`() {
        val expected = 100.0
        val result = calculator.power(10.0, 2.0)
        Assert.assertEquals(expected, result, 0.01)
    }

    @Test
    fun `test 10 power -1`() {
        val expected = 0.1
        val result = calculator.power(10.0, -1.0)
        Assert.assertEquals(expected, result, 0.01)
    }

    @Test
    fun `test 10 power 0`() {
        val expected = 1.0
        val result = calculator.power(10.0, 0.0)
        Assert.assertEquals(expected, result, 0.01)
    }

    @Test
    fun `is 10 prime`() {
        val expected = false
        val result = calculator.isPrime(10)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `is 11 prime`() {
        val expected = true
        val result = calculator.isPrime(11)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `is 17 prime`() {
        val expected = true
        val result = calculator.isPrime(17)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `is 1 prime`() {
        val expected = true
        val result = calculator.isPrime(1)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `is -1 prime`() {
        val expected = true
        val result = calculator.isPrime(-1)
        Assert.assertEquals(expected, result)
    }

    @Test
    fun `is 0 prime`() {
        val expected = false
        val result = calculator.isPrime(0)
        Assert.assertEquals(expected, result)
    }
}