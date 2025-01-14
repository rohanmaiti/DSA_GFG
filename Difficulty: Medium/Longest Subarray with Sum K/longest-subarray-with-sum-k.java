//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
    // Brute force
    //   int maxL = 0;
    //   for(int i=0;i<arr.size();i++){
    //       int sum = 0;
    //       for(int j=i;j<arr.size();j++){
    //           sum += arr[j];
    //           if(sum == k){
    //               maxL = max(maxL, j-i+1);
    //           }
    //       }
    //   }
    //   return maxL;
    
    HashMap<Integer,Integer> m = new HashMap<>();
    int prefixSum = 0;
    int maxL = 0;
    for(int i=0;i<arr.length;i++){
        prefixSum += arr[i];
        if(prefixSum == k){
            maxL = Math.max(maxL,i+1);
        }
        if(m.containsKey(prefixSum - k)){
            // calculate length 
            int index = m.get(prefixSum-k);
            maxL = Math.max(maxL , i-index);
        }
        if (!m.containsKey(prefixSum)) {
                m.put(prefixSum, i);
        }
    }
    return maxL;     }
}
