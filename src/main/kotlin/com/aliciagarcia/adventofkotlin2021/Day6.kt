package  com.aliciagarcia.adventofkotlin2021

import java.io.File

fun main() {
    val day6 = Day6()

    println("passDaysMortal() = ${day6.passDaysMortal(18)}")
    println("passDaysImmortal() = ${day6.passDaysImmortal(18)}")
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

    fun passDaysImmortal(days: Int): Long {

        val population = LongArray(9)
        // can't be done this way because do not have all the numbers
        // currentGenerationLanternfish.groupBy { it }.toSortedMap().values.map { it.count().toLong() }.toLongArray()

        currentGenerationLanternfish.groupBy { it }.forEach{ key,value ->
            population[key]=value.count().toLong()
        }

        (1..days).forEach { _ ->

            val aux: Long = population[0]
            System.arraycopy(population, 1, population, 0, population.size - 1)
            //population = population.copyOfRange(1, population.size-1)
            // this will be shorting the array on each iteration... ¬¬
            population[population.size - 1] = aux
            population[6] += aux
        }

        return population.sum()
    }
}


