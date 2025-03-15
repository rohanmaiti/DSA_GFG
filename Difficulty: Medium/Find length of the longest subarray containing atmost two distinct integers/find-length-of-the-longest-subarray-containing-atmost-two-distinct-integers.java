//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        HashMap<Integer, Integer> m = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = arr.length;
        int ans = 0;
        while(j < n){
            m.put(arr[j],m.getOrDefault(arr[j],0)+1);
            if(m.size()>2){
                
            }
            while(m.size()>2){
                m.put(arr[i],m.get(arr[i])-1);
                if(m.get(arr[i]) == 0)
                m.remove(arr[i]);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
           
        }
        return ans;
    }
}