package Longestincreasingsubsequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Longestincreasingsubsequence {
    public static void main(String[] args) {
        // Generate a list of random numbers
        List<Integer> numbers = GRN(40, 1, 20); //GRN-gernerate random number

        System.out.println("Original List:");
        System.out.println(numbers);

        List<Integer> longestIncreasingSubsequence = findLongestIncreasingSubsequence(numbers);

        System.out.println("LIS:"); //LIS- longest incresing subsequence
        System.out.println(longestIncreasingSubsequence);
    }

    public static List<Integer> findLongestIncreasingSubsequence(List<Integer> nums) {
        int n = nums.size();
        int[] lisLength = new int[n];
        int[] prevIndex = new int[n];

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            lisLength[i] = 1;
            prevIndex[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j) && lisLength[i] < lisLength[j] + 1) {
                    lisLength[i] = lisLength[j] + 1;
                    prevIndex[i] = j;
                }
            }
            if (lisLength[i] > maxLength) {
                maxLength = lisLength[i];
                endIndex = i;
            }
        }

        List<Integer> Longestincreasingsubsequence = new ArrayList();
        while (endIndex != -1) {
            Longestincreasingsubsequence.add(nums.get(endIndex));
            endIndex = prevIndex[endIndex];
        }

     // Reverse the list to get the increasing subsequence in the correct order
        List<Integer> reversedSubsequence = new ArrayList();
        for (int i = Longestincreasingsubsequence.size() - 1; i >= 0; i--) {
            reversedSubsequence.add(Longestincreasingsubsequence.get(i));
        }

        return reversedSubsequence;
    }

    public static List<Integer> GRN(int n, int min, int max) {
    	List<Integer> numbers = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(max - min + 1) + min;
            numbers.add(num);
        }
        return numbers;
    }
}
