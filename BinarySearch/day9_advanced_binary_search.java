import java.util.*;

public class Day9AdvancedBinarySearch {

    // 1. Find First and Last Position (34)
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target) right = mid - 1;
            else left = mid + 1;

            if(nums[mid] == target) ans = mid;
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] <= target) left = mid + 1;
            else right = mid - 1;

            if(nums[mid] == target) ans = mid;
        }
        return ans;
    }

    // 2. Find Peak Element (162)
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if(nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 3. Search a 2D Matrix (74)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    // 4. Koko Eating Bananas (875)
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for(int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;

            for(int p : piles) {
                hours += (p + mid - 1) / mid;
            }

            if(hours <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // 5. Capacity to Ship Packages (1011)
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for(int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        int ans = right;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int neededDays = 1, load = 0;

            for(int w : weights) {
                if(load + w > mid) {
                    neededDays++;
                    load = 0;
                }
                load += w;
            }

            if(neededDays <= days) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

/*
Day 9: Advanced Binary Search

Problems:
1. First & Last Position
2. Peak Element
3. 2D Matrix Search
4. Koko Eating Bananas
5. Ship Packages

Concepts:
- Boundary search
- Binary search on unsorted logic
- 2D → 1D mapping
- Binary search on answer space

Time Complexity: O(log n) / O(n log n)
*/
