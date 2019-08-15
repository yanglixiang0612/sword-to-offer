package com.offer.two;

public class Test23 {
    public static void main(String[] args) {
        
    }
    
    public boolean verifySquenceOfBST(int[] sequence){
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return verifySquenceOfBST1(sequence, 0, sequence.length - 1);
    }

    public boolean verifySquenceOfBST1(int[] sequence, int start, int end) {
        if(start >= end){
            return true;
        }

        int root = sequence[end];
        int i = start;
        while(root > sequence[i]){
            i++;
        }
        int j = i;
        while(j < end){
            if(sequence[j] < root){
                return false;
            }
            j++;
        }
        boolean left = verifySquenceOfBST1(sequence, start, i - 1);
        boolean right = verifySquenceOfBST1(sequence, i, end - 1);
        return left && right;
    }
}
