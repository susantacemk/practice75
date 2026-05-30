import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class CompressedString {
    public static void main(String[] args) {
        // "a","a","b","b","c","c","c"
        System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
    }

    public static int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Itrate through the whole map follow the compressed rule
        for (Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value > 1) {
                String str = key + String.valueOf(value);
                s.append(str);
            } else {
                s.append(key);
            }
        }
        return s.length();
    }
}
