class Solution {
    public int numberOfSubstrings(String s) {
        int lastA = -1, lastB = -1, lastC = -1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                lastA = i;
            else if (c == 'b')
                lastB = i;
            else if (c == 'c')
                lastC = i;

            // If we have seen all three at least once
            if (lastA != -1 && lastB != -1 && lastC != -1) {
                // Any substring starting from index 0 up to min(lastA, lastB, lastC)
                // and ending at i is valid.
                result += Math.min(lastA, Math.min(lastB, lastC)) + 1;
            }
        }
        return result;
    }
}