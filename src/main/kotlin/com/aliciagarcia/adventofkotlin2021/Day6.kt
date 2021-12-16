package  com.aliciagarcia.adventofkotlin2021

import java.io.File

fun main() {
    val day6 = Day6()

    println("passDays() = ${day6.passDaysMortal(18)}")
}


class Day6(fileName: String = "day6.txt") {


    private val file = File(ClassLoader.getSystemResource(fileName).file)


    var currentGenerationLanternfish = file.readLines().stream().findFirst().get().split(",").map { it.toInt() }

    fun passDaysMortal(days: Int): Int {


        (1..days).forEach { _ ->
            currentGenerationLanternfish = getNextGeneration()
        }

        return currentGenerationLanternfish.size

    }

    private fun getNextGeneration(): MutableList<Int> {
        val _temp: MutableList<Int> = currentGenerationLanternfish.toMutableList()

        (currentGenerationLanternfish.indices).forEach { index ->
            if (currentGenerationLanternfish[index] == 0) {
                _temp[index] = 6
                _temp.add(8)
            } else {
                _temp[index] = currentGenerationLanternfish[index] - 1
            }
        }
        return _temp
    }
}


