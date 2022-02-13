package datastructure450.string;

// https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    char ch;
    int frequency;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.frequency = freq;
    }
}

public class RearrangeCharactersInStringSuchThatNoTwoAdjacentAreSame {
    public static void main(String[] args) {
        String str = "bbbaa";
        System.out.println(rearrangeString(str, str.length()));
    }

    // O(n log n) time complexity and O(m) space complexity where m is distinct character count
    private static String rearrangeString(String str, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.frequency));
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        Pair prev = new Pair('#', -1);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            sb.append(pair.ch);
            if (prev.frequency > 0)
                pq.add(prev);
            pair.frequency--;
            prev = pair;
        }
        if (n != sb.length())
            return "Not valid String";
        return sb.toString();
    }
}
