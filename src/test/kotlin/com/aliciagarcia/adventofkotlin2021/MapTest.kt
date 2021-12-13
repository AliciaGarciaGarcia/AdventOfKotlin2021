package com.aliciagarcia.adventofkotlin2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MapTest {

    @Test
    fun drawStraightHorizAscLine() {
        val map = Map(listOf(Pair(Pair(1, 1), Pair(1, 3))), false)

        val expected = mapOf(
            Pair(1, 1) to 1,
            Pair(1, 2) to 1,
            Pair(1, 3) to 1
        )

        Assertions.assertEquals(expected, map.points)
    }

    @Test
    fun drawStraightHorizDescLine() {


        val map = Map(listOf(Pair(Pair(1, 3), Pair(1, 1))), false)

        val expected = mapOf(
            Pair(1, 1) to 1,
            Pair(1, 2) to 1,
            Pair(1, 3) to 1
        )

        Assertions.assertEquals(expected, map.points)
    }

    @Test
    fun drawStraightVertAscLine() {


        val map = Map(listOf(Pair(Pair(1, 1), Pair(3, 1))), false)

        val expected = mapOf(
            Pair(1, 1) to 1,
            Pair(2, 1) to 1,
            Pair(3, 1) to 1
        )

        Assertions.assertEquals(expected, map.points)
    }

    @Test
    fun drawStraightVertDescLine() {

        val map = Map(listOf(Pair(Pair(3, 1), Pair(1, 1))), false)

        val expected = mapOf(
            Pair(1, 1) to 1,
            Pair(2, 1) to 1,
            Pair(3, 1) to 1
        )

        Assertions.assertEquals(expected, map.points)
    }

    @Test
    fun drawDiagonalOrderedLine() {


        val map = Map(listOf(Pair(Pair(1, 1), Pair(3, 3))), true)

        val expected = mapOf(
            Pair(1, 1) to 1,
            Pair(2, 2) to 1,
            Pair(3, 3) to 1
        )

        Assertions.assertEquals(expected, map.points)
    }

    @Test
    fun drawDiagonalInvertedOrderedLine() {


        val map = Map(listOf(Pair(Pair(1, 3), Pair(3, 1))), true)

        val expected = mapOf(
            Pair(3, 1) to 1,
            Pair(2, 2) to 1,
            Pair(1, 3) to 1
        )

        Assertions.assertEquals(expected, map.points)
    }
}