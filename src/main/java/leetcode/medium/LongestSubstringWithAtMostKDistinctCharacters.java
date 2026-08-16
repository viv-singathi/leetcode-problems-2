package leetcode.medium;

public class LongestSubstringWithAtMostKDistinctCharacters {
    //problem: Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2)); //output: 3
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0;
        int u = 0;
        int seen[] = new int[256];
        int d = 0;
        int maxLength = 0;

        while (u < s.length()){
            char c = s.charAt(u++);
            if (l == u || seen[c] == 0 && d < k){
                seen[c]++;
                d++;
            } else if (seen[c] != 0){
                seen[c]++;
            } else {
                u--;
                char o = s.charAt(l++);
                seen[o]--;
                if (seen[o] == 0){
                    d--;
                }
            }

            maxLength = Math.max(maxLength, u - l);
        }

        return maxLength;
    }
}
