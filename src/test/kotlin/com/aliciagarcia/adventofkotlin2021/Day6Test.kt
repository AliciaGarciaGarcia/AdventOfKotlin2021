package com.aliciagarcia.adventofkotlin2021

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day6Test {

    val day6 = Day6("day6Test.txt")

    @Test
    fun day6FirstPart18Test() {
        Assertions.assertEquals(26, day6.passDaysMortal(18))
    }

    @Test
    fun day6FirstPart60Test() {
        Assertions.assertEquals(1042, day6.passDaysMortal(60))
    }

    @Test
    fun day6FirstPart80Test() {
        Assertions.assertEquals(5934, day6.passDaysMortal(80))
    }

//    @Test
//    fun day6FirstPart256Test() {
//        Caused by: java.lang.OutOfMemoryError: Java heap space
//        Assertions.assertEquals(26984457539, day6.passDaysMortal(256))
//    }


    @Test
    fun day6SecondPart18Test() {
        // Assertions.assertEquals(26, secondPart.secondPart(18))
    }

    @Test
    fun day6SecondPart60Test() {
        //Assertions.assertEquals(1042, secondPart.secondPart(60))
    }

    @Test
    fun day6SecondPart80Test() {

        //Assertions.assertEquals(5934, secondPart.secondPart(80))
    }

    @Test
    fun day6SecondPart256Test() {

        //Assertions.assertEquals(26984457539, secondPart.secondPart(256))
    }


}