package leetcode.medium;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int max_len = 0;
        int seen[] = new int[96];
        int start = 0;

        for (int i = 0; i < 96; i++){
            seen[i] = -1;
        }

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (seen[c - ' '] >= start){
                start = seen[c - ' '] + 1;
            }

            seen[c - ' '] = i;

            int dist = i - start + 1;

            if (dist >= max_len){
                max_len = dist;
            }
        }

        return max_len;
    }
}
