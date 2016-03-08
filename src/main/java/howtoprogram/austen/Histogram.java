package howtoprogram.austen;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Collects word usage data.
 */
public class Histogram {

    private Map<String,Integer> counter = new HashMap<>();

    public void record(String word) {
        Integer currentCount;
        if (counter.containsKey(word)) {
            currentCount = counter.get(word);
        } else {
            currentCount = 0;
        }
        Integer newCount = currentCount + 1;
        counter.put(word, newCount);
    }

    public Set<String> allWords() {
        return counter.keySet();
    }

    public int numberOfTimesGiven(String word) {
        if (counter.containsKey(word)) {
            return counter.get(word);
        } else {
            return 0;
        }
    }
}
