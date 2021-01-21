class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack=new Stack<>();
        int result[]=new int[k];
        for(int i=0;i<nums.length;i++)
        {
            while(!stack.isEmpty() && nums[i]<nums[stack.peek()] && stack.size()+nums.length-i>k)
            {
                stack.pop();
            }
            if(stack.size()<k)
            {
                stack.push(i);
            }
        }
        int i=k;
        while(!stack.isEmpty())
        {
            result[--i]=nums[stack.pop()];
        }
        return result;
    }
}