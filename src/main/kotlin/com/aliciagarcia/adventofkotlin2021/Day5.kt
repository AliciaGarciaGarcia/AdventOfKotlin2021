package  com.aliciagarcia.adventofkotlin2021

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val day5 = Day5()

    var day5Map = Map(day5.lines, false)

    println("getDangerPointsCount() = ${day5Map.getDangerPointsCount()}")

    day5Map = Map(day5.lines, true)

    println("getDangerPointsCount() = ${day5Map.getDangerPointsCount()}")
}


class Day5(fileName: String = "day5.txt") {
    private val file = File(ClassLoader.getSystemResource(fileName).file)

    val lines = readLines(file)

    private fun readLines(file: File): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
        val lines = file.readLines()

        return lines.map { line ->
            val (point1, point2) = line.split(" -> ")
            val (x1, y1) = point1.split(",")
            val (x2, y2) = point2.split(",")
            Pair(Pair(x1.toInt(), y1.toInt()), Pair(x2.toInt(), y2.toInt()))
        }
    }
}

class Map(lines: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>, val drawsDiagonals: Boolean = false) {

    val points = mutableMapOf<Pair<Int, Int>, Int>()

    init {
        for (line in lines) {
            drawLine(line.first, line.second)
        }

    }


    private fun drawLine(start: Pair<Int, Int>, end: Pair<Int, Int>) {
        if (start.first == end.first || start.second == end.second) {
            drawStraightLine(start, end)
        } else if (drawsDiagonals) {
            drawDiagonalLine(start, end)
        }

    }

    private fun drawStraightLine(start: Pair<Int, Int>, end: Pair<Int, Int>) {
        if (start.first == end.first) {
            (min(start.second, end.second)..max(start.second, end.second)).forEach {
                points[Pair(start.first, it)] = points.getOrElse(Pair(start.first, it)) { 0 } + 1
            }
        } else {
            (min(start.first, end.first)..max(start.first, end.first)).forEach {
                points[Pair(it, start.second)] = points.getOrElse(Pair(it, start.second), { 0 }) + 1
            }
        }
    }

    private fun drawDiagonalLine(start: Pair<Int, Int>, end: Pair<Int, Int>) {

        //this guarantees that you can use the zip method. If not this solution is not valid 🙁
        if (abs(start.first - end.first) == abs(start.second - end.second)) {

            val x = if (start.first < end.first) {
                (start.first..end.first)
            } else {
                (start.first.downTo(end.first))
            }

            val y = if (start.second < end.second) {
                (start.second..end.second)
            } else {
                (start.second.downTo(end.second))
            }

            (x).zip(y).forEach { points[it] = points.getOrElse(it, { 0 }) + 1 }
        }
    }

    fun getDangerPointsCount() = points.values.count { it > 1 }

}