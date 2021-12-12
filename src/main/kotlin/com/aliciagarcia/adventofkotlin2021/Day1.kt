package  com.aliciagarcia.adventofkotlin2021

import java.io.File
import java.nio.file.Files
import java.util.concurrent.atomic.AtomicInteger
import kotlin.streams.toList


class Day1 {


    val file = File(ClassLoader.getSystemResource("day1.txt").file)
    val lines = Files.lines(file.toPath())
    val beeps: List<Int> = lines.map { it.toInt() }.toList()

    fun firstPart(): Int {

        val counter = AtomicInteger()

        for (i in 1 until beeps.size) {
            if (beeps[i] > beeps[i - 1]) {
                counter.getAndIncrement()
            }
        }
        return counter.get()
    }

    fun windowed(windowSize: Int = 2): Int = beeps.windowed(windowSize).count { it[0] < it[windowSize - 1] }

    fun secondPartFold(windowSize: Int = 1): Int {
        val initial = AtomicInteger()
        val x = beeps.foldRightIndexed(initial) { i, _, counter ->
            if (i < beeps.size - windowSize) {
                val x = beeps.subList(i, i + windowSize).sum()
                val y = beeps.subList(i + 1, i + windowSize + 1).sum()
                if (x < y) counter.apply { getAndIncrement() } else counter
            } else counter
        }
        return x.get()
    }

    fun secondPart(windowSize: Int = 1): Int {
        val counter = AtomicInteger()

        (0 until beeps.size - windowSize).forEach { i ->
            val x = beeps.subList(i, i + windowSize).sum()
            val y = beeps.subList(i + 1, i + windowSize + 1).sum()
            if (x < y) {
                counter.getAndIncrement()
            }
        }


        return counter.get()
    }
}