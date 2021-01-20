class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char ch;
        if(s.length()%2!=0)
            return false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty())
                return false;
            if(s.charAt(i)==')')
            {
                ch=stack.pop();
                if(ch=='{'||ch=='[')
                    return false;
            }
            else if(s.charAt(i)==']')
            {
                ch=stack.pop();
                if(ch=='{'||ch=='(')
                    return false;
            }
            else if(s.charAt(i)=='}')
            {
                ch=stack.pop();
                if(ch=='('||ch=='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}