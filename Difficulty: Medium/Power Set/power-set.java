//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void sol(String s, String str, int index, List<String> ans){
        if(index >= s.length()){
            if(str.length() > 0){
                ans.add(str);
            }
            return ;
        }
        // exclude
        sol(s,str,index+1,ans);
        // include
        str += s.charAt(index);
        sol(s,str,index+1,ans);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> ans = new ArrayList<>();
        String str = "";
        int index = 0;
        sol(s,str,index,ans);
        Collections.sort(ans);
        return ans;
       
    }
}