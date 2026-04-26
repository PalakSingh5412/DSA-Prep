import java.util.*;

public class Day8SlidingWindow {

    // 1. Maximum Average Subarray I (LeetCode 643)
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // first window
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // slide window
        for(int i = k; i < nums.length; i++) {
            sum += nums[i];        // add next element
            sum -= nums[i - k];    // remove left element
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    // 2. Longest Substring Without Repeating Characters (LeetCode 3)
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for(int right = 0; right < s.length(); right++) {

            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // 3. Minimum Size Subarray Sum (LeetCode 209)
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}

/*
Day 8: Sliding Window Pattern

Problems:
1. Maximum Average Subarray I (643)
2. Longest Substring Without Repeating Characters (3)
3. Minimum Size Subarray Sum (209)

Concept:
- Maintain a window (left → right)
- Expand window → increase size
- Shrink window → meet condition

Time Complexity: O(n)
Space Complexity: O(n)
*/
