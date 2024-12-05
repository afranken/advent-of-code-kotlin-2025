import java.util.regex.Pattern

fun main() {
    fun part1(input: List<String>): Int {

        var result = 0

        val FIND_MUL = Regex("(mul\\(\\d+,\\d+\\))")
        val muls = input.flatMap {
            FIND_MUL.findAll(it).map { it.value }
        }

        for(mul in muls) {
            val (a,b) = mul.removePrefix("mul(").removeSuffix(")").split(',')
            result += a.toInt()*b.toInt()
        }

        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0

        val FIND_ALL = Regex("mul\\(\\d+,\\d+\\)|do(n't)?\\(\\)")
        val all = input.flatMap {
            FIND_ALL.findAll(it).map { it.value }
        }

        var enabled = true

        for (item in all) {
            if(item == "do()") {
                enabled = true
            } else if (item == "don't()") {
                enabled = false
            } else if(enabled) {
                val (a,b) = item.removePrefix("mul(").removeSuffix(")").split(',')
                result += a.toInt()*b.toInt()
            }
        }

        return result
    }

    val testInput = readInput("Day03_test")
    val input = readInput("Day03")

    check(part1(testInput) == 161)
    part1(input).println()

    check(part2(testInput) == 48)
    part2(input).println()
}
