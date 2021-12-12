import com.aliciagarcia.adventofkotlin2021.Day1

fun main(args: Array<String>) {
    val day1 = Day1()
    println("Day 1st part ${day1.firstPart()}")
    println("Day 1st part window ${day1.windowed()}")
    println("Day 2nd part ${day1.secondPart(3)}")
    println("Day 2nd part fold ${day1.secondPartFold(3)}")
    println("Day 2nd part window ${day1.windowed(4)}")

}