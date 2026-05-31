public class ConsicutiveSum {
    public static void main(String[] args) {
        System.out.println(isSumOfConsicutive(8));
    }

    public static boolean isSumOfConsicutive(int n) {
        // for (int i = 1; i <= n / 2; i++) {
        // int sum = i;
        // for (int j = i + 1; j < n; j++) {
        // sum += j;
        // if (sum == n) {
        // return true;
        // } else if (sum > n) {
        // break;
        // }
        // }
        // }
        // return false;
        // 1 cannot be represented as a sum of 2 or more consecutive positive numbers
        if (n == 1) {
            return false;
        }

        // Check if n is a power of 2 using bitwise AND
        // If it is a power of 2, it cannot be expressed, so return false
        if ((n & (n - 1)) == 0) {
            return false;
        }

        // Any other number can be expressed
        return true;
    }
}
