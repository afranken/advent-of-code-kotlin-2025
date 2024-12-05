fun main() {
    fun part1(input: List<String>): Int {
        val reports = input.map { it.split(" ").map { s -> s.toInt() } }

        val validReport = reports.map {
            it.isValidReport()
        }

        return validReport.count { it }
    }

    fun part2(input: List<String>): Int {
        val reports = input.map { it.split(" ").map { s -> s.toInt() } }

        val validReport = reports.map {
            for (i in 0..it.lastIndex) {
                val safe = it.toMutableList().apply { removeAt(i) }.isValidReport()
                if(safe) return@map true
            }
            return@map false
        }

        return validReport.count { it }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()

    val testInput2 = readInput("Day02_test")
    check(part2(testInput2) == 4)

    part2(input).println()
}

private fun List<Int>.isValidReport(): Boolean {
    val levelPairs = this.zipWithNext()
    val increasing = levelPairs.all { (a, b) ->
        b - a in 1..3
    }
    val decreasing = levelPairs.all { (a, b) ->
        b - a in (-3)..(-1)
    }
    return increasing || decreasing
}