package pfb.austen

/**
 * Collects word usage data.
 */
class Histogram {

    val counter = mutableMapOf<String, Int>()

    fun record(word: String) {
        val currentCount = counter[word] ?: 0
        val newCount = currentCount + 1
        counter.put(word, newCount)
    }

    fun allWords(): Set<String> {
        return counter.keys
    }

    fun numberOfTimesGiven(word: String): Int {
        return counter[word] ?: 0
    }
}