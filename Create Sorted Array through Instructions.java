/*
   Fenwick tree is also known as Binary index tree. It is mainly used to find prefix sum in (log n) time.
*/

class Solution {
    public int createSortedArray(int[] instructions) {
        int max=0;
        for(int i : instructions)
        {
            max=Math.max(i,max);
        }
        Fenwick fenwick = new Fenwick(max+2);
        int result=0;
        for(int i=0;i<instructions.length;i++)
        {
            int current=instructions[i];
            int low=fenwick.Range(0,current-1);
            int high=fenwick.Range(current+1,max);
            result+=Math.min(low,high);
            result=result%1000000007;
            fenwick.update(current,1);
        }
        return result;
    }
}


class Fenwick{
    int arr[];
    Fenwick(int len)
    {
        this.arr=new int[len];
    }
    
    //SUM
    public int Range(int start,int end)
    {
        return sum(end+1)-sum(start);
    }
    
    public int sum(int index)
    {
        int sum=0;
        while(index>0)
        {
            sum+=arr[index];
            index=index-(index & -index);
        }
        return sum;
    }
    
    //Update count
    public void update(int index,int value)
    {
        index++;
        while(index<arr.length)
        {
            arr[index]+=value;
            index=index+(index & -index);
        }
    }
}