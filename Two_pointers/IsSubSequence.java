package Two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsSubSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the String s::");
        String s = bf.readLine();
        System.out.print("Enter the String t::");
        String t = bf.readLine();
        System.out.println("Is s is subsequence of t ?: " + isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty() || t.equals(s))
            return true;
        int j = 0; // iterating to s string
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
                if (j == s.length()) {
                    return true; // all character of s string is iterate
                }
            }
        }
        return j == s.length();
    }
}
