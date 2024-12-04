fun main() {
    fun part1(input: List<String>): Int {
        val inputPairs = input.map { s ->
            val (a, b) = s.split("   ")
            a to b
        }

        val leftSorted = inputPairs.map { s -> s.first.toInt() }.sorted()
        val rightSorted = inputPairs.map { s -> s.second.toInt() }.sorted()

        val sortedPairs = leftSorted.zip(rightSorted)

        val distances = sortedPairs.map { pair ->
            if (pair.first > pair.second) {
                pair.first - pair.second
            } else {
                pair.second - pair.first
            }
        }

        return distances.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
