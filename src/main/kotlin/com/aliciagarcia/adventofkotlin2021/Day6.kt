package  com.aliciagarcia.adventofkotlin2021

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val day6 = Day6()

    println("passDays() = ${day6.passDaysMortal(18)}")
}


class Day6(fileName: String = "day6.txt") {


    private val file = File(ClassLoader.getSystemResource(fileName).file)


    val firstGenerationLanternfish = file.readLines().stream().findFirst().get().split(",").map{it.toInt()}

    fun passDaysMortal(days:Int):Int{


        return 0;

    }
}


