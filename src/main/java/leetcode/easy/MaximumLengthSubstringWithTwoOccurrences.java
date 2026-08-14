package leetcode.easy;

public class MaximumLengthSubstringWithTwoOccurrences {
    //problem: Given a string s, return the maximum length of a substring such that it contains at most two occurrences of each character
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba")); //output: 4
    }


    public static int maximumLengthSubstring(String s) {
        int seen[] = new int[26];

        int l = 0;
        int u = 0;
        int max = 0;

        while (u < s.length()){
            char c = s.charAt(u);
            if (l == u || seen[c-'a'] < 2){
                u++;
                seen[c - 'a']++;
            } else {
                seen[s.charAt(l++) -'a']--;
            }
            max = Math.max(u-l, max);
        }

        return max;
    }
}
