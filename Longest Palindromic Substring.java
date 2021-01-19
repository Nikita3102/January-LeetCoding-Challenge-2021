//Time: O(n^2)
// Space: O(1)
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length() < 1)
            return "";
        
        int start=0,end=0;
        for(int i=0; i < s.length();i++)
        {
            int len1= expandFromMid(s,i,i); // for the case where middle character is appearing only one time. eg: racecar
            int len2=expandFromMid(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len > end-start)
            {
                start=i-((len-1)/2);
                end=i+(len/2);
            }
        }
        return s.substring(start,end+1);
    }
    
        public int expandFromMid(String s,int left,int right) //returns length of longest palindromic substring
        {
            if(s==null || left>right)
                return 0;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right))
            {
                left--;   //expand length outwards
                right++;
            }
            return right-left-1;
        }
}