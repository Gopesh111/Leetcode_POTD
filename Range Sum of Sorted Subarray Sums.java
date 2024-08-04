import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();

        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums.add(sum);
            }
        }

        // Sort the subarray sums
        Collections.sort(subarraySums);

        // Compute the sum from index left to right (1-indexed)
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        System.out.println("Enter the length of the array (n):");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the left index:");
        int left = scanner.nextInt();

        System.out.println("Enter the right index:");
        int right = scanner.nextInt();

        // Calculate and print the result
        Solution solution = new Solution();
        int result = solution.rangeSum(nums, n, left, right);
        System.out.println("The sum of the numbers from index " + left + " to " + right + " is: " + result);

        scanner.close();
    }
}
