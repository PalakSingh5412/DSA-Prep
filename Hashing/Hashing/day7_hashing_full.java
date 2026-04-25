import java.util.*;

public class Day7HashingFull {

    // 1. Valid Anagram (LeetCode 242)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        for(int count : freq) {
            if(count != 0) return false;
        }

        return true;
    }

    // 2. Ransom Note (LeetCode 383)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for(char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if(freq[c - 'a'] == 0) return false;
            freq[c - 'a']--;
        }

        return true;
    }

    // 3. Contains Duplicate (LeetCode 217)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

    // 4. Intersection of Two Arrays (LeetCode 349)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for(int num : nums1) {
            set1.add(num);
        }

        for(int num : nums2) {
            if(set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;

        for(int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }

    // 5. Group Anagrams (LeetCode 49)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

/*
Day 7: Full Hashing Set

Problems:
1. Valid Anagram (242)
2. Ransom Note (383)
3. Contains Duplicate (217)
4. Intersection of Two Arrays (349)
5. Group Anagrams (49)

Concepts:
- Frequency arrays
- HashSet (uniqueness)
- HashMap (grouping)
- Sorting as key

Time Complexity:
- Mostly O(n)
- Group Anagrams: O(n * k log k)

Space Complexity: O(n)
*/
