import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryCAssignment {

    // --- A1. Product of Array Except Self ---
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Left pass
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Right pass
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    // --- A2. Maximum Subarray ---
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // --- A3. 3Sum ---
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[] { nums[i], nums[left], nums[right] });

                    // Skip duplicate left and right values
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    // --- A4. Subarray Sum Equals K ---
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Base case for subarrays starting at index 0

        for (int num : nums) {
            currentSum += num;
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    // --- A5. Find Minimum in Rotated Sorted Array ---
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.println("=== A1. Product of Array Except Self ===");
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));

        System.out.println("\n=== A2. Maximum Subarray ===");
        System.out.println("Max Subarray Sum: " + maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println("Max Subarray Sum: " + maxSubArray(new int[] { -3, -1, -2 }));

        System.out.println("\n=== A3. 3Sum ===");
        int[][] res3Sum = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        System.out.print("[");
        for (int[] triplet : res3Sum) {
            System.out.print(Arrays.toString(triplet) + " ");
        }
        System.out.println("]");

        System.out.println("\n=== A4. Subarray Sum Equals K ===");
        System.out.println("Subarrays Count: " + subarraySum(new int[] { 1, 1, 1 }, 2));
        System.out.println("Subarrays Count: " + subarraySum(new int[] { 1, -1, 0 }, 0));

        System.out.println("\n=== A5. Find Minimum in Rotated Sorted Array ===");
        System.out.println("Minimum: " + findMin(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println("Minimum: " + findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println("Minimum: " + findMin(new int[] { 11, 13, 15, 17 }));
    }
}