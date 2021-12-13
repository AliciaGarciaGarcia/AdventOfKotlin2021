package com.aliciagarcia.adventofkotlin2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day5Test {

    @Test
    fun day5Part1Test() {
        val day5 = Day5("day5Test.txt")

        val day5Map = Map(day5.lines, false)

        Assertions.assertEquals(5, day5Map.getDangerPointsCount())
    }

    @Test
    fun day5Part2Test() {
        val day5 = Day5("day5Test.txt")

        val day5Map = Map(day5.lines, true)

        Assertions.assertEquals(12, day5Map.getDangerPointsCount())
    }
}