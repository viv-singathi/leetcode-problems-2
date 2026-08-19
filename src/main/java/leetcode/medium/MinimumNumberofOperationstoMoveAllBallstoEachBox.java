package leetcode.medium;

import java.util.Arrays;

public interface MinimumNumberofOperationstoMoveAllBallstoEachBox {
    //problem: You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
    //In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
    // Note that after doing so, there may be more than one ball in some boxes.
    //Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
    //Each answer[i] is calculated considering the initial state of the boxes
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110"))); //output: [1, 1, 3]
    }

    public static int[] minOperations(String boxes) {
        int l = boxes.length();
        int res[] = new int[l];
        int ballsAfter = 0;
        int afterSum = 0;

        for (int i = l-1; i >= 0; i--){
            ballsAfter += boxes.charAt(i) - '0';
            afterSum += ballsAfter;
        }

        int ballsBefore = 0;
        int beforeSum = 0;

        for (int i = 0; i < res.length; i++){
            beforeSum += ballsBefore;
            afterSum -= ballsAfter;
            char c = boxes.charAt(i);
            if (c == '1'){
                ballsBefore++;
                ballsAfter--;
            }
            res[i] = beforeSum + afterSum ;


        }

        return res;
    }
}
