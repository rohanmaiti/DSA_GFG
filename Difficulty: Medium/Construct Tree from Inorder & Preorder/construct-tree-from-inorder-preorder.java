//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    static int index = 0;
    
    static int findPos(int ele,int inorder[],int size){
        for(int i=0;i<size;i++){
            if(ele == inorder[i])
            return i;
        }
        return -1;
    }
    static Node sol(int inorder[],int preorder[],int start, int end,int size){
        if(index > size || end<start){
            return null;
        }
        int ele = preorder[index];
        index++;
        Node root = new Node(ele);
        int pos = findPos(ele,inorder,size);
        root.left = sol(inorder,preorder,start,pos-1,size);
        root.right = sol(inorder,preorder,pos+1,end,size);
        
        return root;
        
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        int n = inorder.length;
        if(n == 0)
        return null;
        index = 0;
        return sol(inorder,preorder,0,n-1,n);
    }
}
