class Solution {
    public String shortestPalindrome(String s) {
        if(s==null||s.length()==0) return s;
        String rev=new StringBuilder(s).reverse().toString();
        String combined=s+"#"+rev;
        int[] lps=buildLPS(combined);

        int charsToAdd=s.length()-lps[combined.length()-1];
        return rev.substring(0,charsToAdd)+s;
    }

    private int[] buildLPS(String s)
    {
        int n=s.length();
        int[] lps=new int[n];
        int len=0;
        int i=1;

        while(i<n)
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}