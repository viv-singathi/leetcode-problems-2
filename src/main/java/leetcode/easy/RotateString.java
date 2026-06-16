package leetcode.easy;

public class RotateString {
    //problem: Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
    //A shift on s consists of moving the leftmost character of s to the rightmost position.

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab")); //output: true
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {return false;}
        int len = goal.length();

        for (int start = 0; start < len; start++){
            for (int i = 0; i < len; i++){
                if (s.charAt(i) != goal.charAt((i + start) % len)){
                    break;
                }
                if (i == len-1){
                    return true;
                }
            }
        }

        return false;
    }
}
