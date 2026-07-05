package leetcode.easy;

public class IsSubsequence {
    //problem:Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    //A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    // of the characters without disturbing the relative positions of the remaining characters
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); //output: true
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) { return true;}
        int c = 0;
        for (int i = 0; i < t.length(); i++){
            if (t.charAt(i) == s.charAt(c)){
                c++;
                if (c == s.length()){
                    return true;
                }
            }
        }

        return false;
    }
}
