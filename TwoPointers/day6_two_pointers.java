import java.util.*;

public class Day6TwoPointers {

    // 1. Move Zeroes (LeetCode 283)
    public void moveZeroes(int[] nums) {
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    // 2. Valid Palindrome (LeetCode 125)
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {

            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // 3. Merge Sorted Array (LeetCode 88)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

/*
Day 6: Two Pointer Pattern

Problems:
1. Move Zeroes (283)
2. Valid Palindrome (125)
3. Merge Sorted Array (88)

Concept:
- Two pointers (left/right)
- In-place modification
- Pointer movement logic

Time Complexity: O(n)
Space Complexity: O(1)
*/
