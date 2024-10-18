public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("The Sky is Blue"));
    }
    public static String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        // create a temp array to split of given string s
        String[] temp = s.split(" ");
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] == "") {
                continue;
            }
            str.append(temp[i]);
            if (i != 0) {
                str.append(" ");
            }
        }
        return str.toString().trim();
    }
}