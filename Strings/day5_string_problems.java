import java.util.*;

public class Day5StringProblems {

    // 1. Reverse String (LeetCode 344)
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    // 2. Find Words Containing Character (LeetCode 2942)
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }

        return result;
    }

    // 3. Vowel-Consonant Score (LeetCode 3813)
    public int scoreOfString(String s) {
        int score = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if("aeiou".indexOf(ch) != -1) {
                score += 1;
            } else if(Character.isLetter(ch)) {
                score -= 1;
            }
        }

        return score;
    }

    // 4. Toggle Light Bulbs (LeetCode 3842)
    public int toggleBulbs(int n) {
        int count = 0;

        for(int i = 1; i * i <= n; i++) {
            count++;
        }

        return count;
    }
}

/*
Day 5: String & Logic Problems

Problems:
1. Reverse String (344)
2. Find Words Containing Character (2942)
3. Vowel-Consonant Score (3813)
4. Toggle Light Bulbs (3842)

Concepts:
- Two pointers
- String traversal
- Character classification
- Mathematical pattern (perfect squares)

Time Complexity: O(n) / O(sqrt(n))
*/
