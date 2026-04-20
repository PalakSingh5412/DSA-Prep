import java.util.HashMap;

public class Day0TwoSum {

    // Brute Force Approach
    public static int[] twoSumBrute(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Optimized Approach (HashMap)
    public static int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

/*
Problem: Two Sum

Approach 1 (Brute Force):
- Check every pair
- Time: O(n^2)

Approach 2 (HashMap):
- Store elements in map
- Check complement in O(1)
- Time: O(n)

Space Complexity: O(n)
*/
