
import java.util.*;

class Solution {
    // Correctly initialize the mapping array for digits 0-9
    // Index 0 and 1 are empty because they don't map to letters
    private String[] mapping = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: if the current combination length matches digits length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = mapping[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c); // Choose
            backtrack(result, current, digits, index + 1); // Explore
            current.deleteCharAt(current.length() - 1); // Backtrack (Un-choose)
        }
    }
}