class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev=-k-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if(i-prev-1<k)
                    return false;
                prev=i;
            }
        }
        return true;
    }
}