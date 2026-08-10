package leetcode.medium;

public class MaximumSubstringsWithDistinctStart {
    //problem: You are given a string s consisting of lowercase English letters.
    //Return an integer denoting the maximum number of substrings you can split s into such that each
    // substring starts with a distinct character
    public static void main(String[] args) {
        System.out.println(maxDistinct("abab")); //output: 2
    }

    public static int maxDistinct(String s) {
        int seen[] = new int[26];
        int res = 0;
        int l = s.length();

        for (int i = 0; i < l; i++){
            char c = s.charAt(i);
            if (seen[c - 'a'] == 0){
                res++;
                seen[c - 'a']++;
            }
        }

        return res;
    }
}
