//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String[] input = br.readLine().trim().split(" ");
            for (String s : input) {
                arr.add(Integer.parseInt(s));
            }
            int k = Integer.parseInt(br.readLine().trim());

            Solution obj = new Solution();
            boolean ans = obj.canPair(arr, k);
            System.out.println(ans ? "true" : "false");
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canPair(List<Integer> arr, int k) {
        // code here.
        int n = arr.size();
        if(n % 2 != 0) return false;
        int temp[] = new int[n];
        for(int i=0;i<n;i++){
            temp[i] = arr.get(i) % k;
        }
        // 9 5 7 3
        // 3 5 1 3
        // 0 1 2 3 4 5 
        //           1
        int freq[] = new int[k];
        
        Arrays.fill(freq,0);
        for(int i=0;i<n;i++){
            int x = arr.get(i) % k;
            if(freq[(k-x)%k] != 0){
                freq[(k-x)%k]--;
            }
            else{
                freq[x]++;
            }
        }
        for(int i=0;i<k;i++){
            if(freq[i] > 0){
                return false;
            }
        }
        return true;
        
        
    }
}
