public class CompressedString {
    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int len = compress(chars);
        System.out.println(len); // Output: 6 (a2b2c3)
    }

    /**
     * Compresses a character array in-place using character-count encoding.
     * Consecutive duplicate characters are replaced by the character followed by count.
     * e.g., ['a','a','b','b','c','c','c'] becomes ['a','2','b','2','c','3'] with length 6.
     *
     * @param chars input array of lowercase English letters (non-empty, length <= 10000)
     * @return the new length after compression
     * @implNote Uses O(1) space by modifying array in-place with two-pointer technique
     */
    public static int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;

        // First pass: calculate compressed length
        int compressedLen = 0;
        for (int i = 0; i < chars.length; ) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            compressedLen += count == 1 ? 1 : 1 + String.valueOf(count).length();
        }

        // If compression doesn't save space, return original length
        if (compressedLen >= chars.length) return chars.length;

        // Second pass: fill array in-place from right to left
        int writeIdx = compressedLen - 1;
        for (int i = chars.length - 1; i >= 0; ) {
            char current = chars[i];
            int count = 0;
            while (i >= 0 && chars[i] == current) {
                count++;
                i--;
            }
            // Write count digits (if count > 1) from right to left
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[writeIdx--] = digit;
                }
            }
            chars[writeIdx--] = current;
        }

        return compressedLen;
    }
}
