//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // public static int ans = 0;
    public int sol(int arr[], int idx, int sum, int total,int dp[][]){
     if (idx == arr.length) {
            return Math.abs(sum - (total - sum));
        }
        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }
        
        int take = sol(arr, idx + 1, sum + arr[idx], total, dp);
        int notTake = sol(arr, idx + 1, sum, total, dp);
        return dp[idx][sum] = Math.min(take, notTake);
    }
    public int minDifference(int arr[]) {
        // Your code goes here
        int total = 0;
        for (var num : arr) {
            total += num;
        }
        int dp[][] = new int[arr.length+1][total+1];
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<total+1;j++)
            dp[i][j] = -1;
        }
        
        return sol(arr, 0, 0, total,dp);
        // return ans;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends