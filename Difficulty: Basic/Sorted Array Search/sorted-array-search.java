//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int k = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.searchInSorted(arr, k));
        }
    }
}
// } Driver Code Ends

class Solution {
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        // apply binary search
        int left = 0;
        int right = arr.length - 1 ;
        while( left <= right){
            int min = (left + right)/2;
            if(arr[min] == k) return true;
            if(arr[min] > k){
                right = min-1;
            }
            else {
                left = min+1;
            }
        }
        return false;
    }
}