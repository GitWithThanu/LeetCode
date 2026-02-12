class Solution {
   

    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int[] freq=new int[128];
        int left=0;
        int maxLen=0;

        for(int right=0;right<n;right++)
        {
            char c=s.charAt(right);
            freq[c]++;
            
            while(freq[c]>1)
            {
                char leftChar=s.charAt(left);
                freq[leftChar]--;
                left++;

            }
            maxLen=Math.max(maxLen,right-left+1);

        }
        return maxLen;
    }
}