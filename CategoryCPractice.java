import java.util.Arrays;

public class CategoryCPractice {

    // --- L1. Two Sum ---
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    // --- L2. Best Time to Buy and Sell Stock ---
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    // --- L3. Contains Duplicate ---
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // --- L4. Merge Two Sorted Arrays ---
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }

        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    // --- L5. Rotate Array ---
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return nums;

        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }

        return nums;
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== L1. Two Sum ===");
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));

        System.out.println("\n=== L2. Best Time to Buy and Sell Stock ===");
        System.out.println("Max Profit: " + maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println("Max Profit: " + maxProfit(new int[] { 7, 6, 4, 3, 1 }));

        System.out.println("\n=== L3. Contains Duplicate ===");
        System.out.println("Contains Duplicate: " + containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println("Contains Duplicate: " + containsDuplicate(new int[] { 1, 2, 3, 4 }));

        System.out.println("\n=== L4. Merge Two Sorted Arrays ===");
        System.out.println(Arrays.toString(mergeSortedArrays(new int[] { 1, 3, 5 }, new int[] { 2, 4, 6 })));
        System.out.println(Arrays.toString(mergeSortedArrays(new int[] {}, new int[] { 1, 2, 3 })));

        System.out.println("\n=== L5. Rotate Array ===");
        System.out.println(Arrays.toString(rotateArray(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[] { 1, 2 }, 3)));
    }
}
