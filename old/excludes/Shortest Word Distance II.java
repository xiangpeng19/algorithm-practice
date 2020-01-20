package excludes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    Map<String, List<Integer>> map;

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        WordDistance ins = new WordDistance(words);
        System.out.println(ins.shortest("makes", "coding"));

    }

    public WordDistance(String[] words) {
        map = new HashMap<>();


        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }

            map.get(words[i]).add(i);
        }

    }

    public int shortest(String word1, String word2) {
        List<Integer> ws1 = map.get(word1);
        List<Integer> ws2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < ws1.size() && j < ws2.size()) {
            int w1 = ws1.get(i);
            int w2 = ws2.get(j);
            min = Math.min(Math.abs(w1 - w2), min);
            if (w1 < w2) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}