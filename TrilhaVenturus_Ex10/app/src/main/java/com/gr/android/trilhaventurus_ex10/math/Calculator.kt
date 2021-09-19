package com.gr.android.trilhaventurus_ex10.math

import kotlin.math.pow

internal class Calculator {
    fun sum(first: Int, second: Int): Int {
        return first + second
    }

    fun subtraction(first: Int, second: Int): Int {
        return first - second
    }

    fun division(first: Int, second: Int): Double {
        if (second != 0) {
            return (first / second).toDouble()
        }
        return 0.0
    }

    fun multiplication(first: Int, second: Int): Int {
        return first * second
    }

    fun power(first: Double, second: Double): Double {
        return first.pow(second)
    }

    fun isPair(number: Int): Boolean {
        return (number % 2 == 0)
    }

    fun isPrime(number: Int): Boolean {

        var count = 2
        var i = number - 1

        if (number == 0) return false

        while (i > 1) {
            if (number % i == 0) count++
            i--
        }

        return count == 2
    }
}