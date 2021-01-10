class Solution {
    public int countArrangement(int n) {
       if(n<1) 
           return 0;
        int[] result={0};
        int[] visited=new int[n+1];
        help(n,1,visited,result);
        return result[0];
    }
    private void help(int n,int start,int[] visited,int[] result)
    {
        if(start>n)
        {
            result[0]++;
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==0 && (start%i==0 || i%start==0))
            {
                visited[i]=i;
                help(n,start+1,visited,result);
                visited[i]=0;
            }
        }
    }
}