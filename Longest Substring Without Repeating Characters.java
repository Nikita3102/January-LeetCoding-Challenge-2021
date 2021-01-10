class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,len=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        while(right<s.length())
        {
            if(map.containsKey(s.charAt(right)))
            {
                left=Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}