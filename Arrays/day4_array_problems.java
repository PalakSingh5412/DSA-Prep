import java.util.*;

public class Day4ArrayProblems {

    // 1. Pascal Triangle II
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        for(int i = 0; i <= rowIndex; i++) {
            row.add(1);
            for(int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    // 2. Remove Duplicates
    public int removeDuplicates(int[] nums) {
        int i = 0;
        
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // 3. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if(price < minPrice) {
                minPrice = price;
            } else if(price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}

/*
Day 4: Array Problems

Problems Covered:
1. Pascal Triangle II
2. Remove Duplicates from Sorted Array
3. Best Time to Buy and Sell Stock

Concepts:
- Space optimization
- Two pointers
- Greedy approach

Time Complexity: O(n)
Space Complexity: O(1) or O(n)
*/
