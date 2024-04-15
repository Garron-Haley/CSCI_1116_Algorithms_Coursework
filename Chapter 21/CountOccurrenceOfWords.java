import java.util.*;

public class CountOccurrenceOfWords {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        ArrayList<WordOccurrence> list = new ArrayList<>();
        for ( Map.Entry<String, Integer> entry: map.entrySet())
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        Collections.sort(list);
        Collections.reverse(list);
        int i = 0;
        list.forEach((k) -> System.out.println(k));


    }
}