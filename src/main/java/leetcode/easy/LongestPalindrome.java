package leetcode.easy;

public class LongestPalindrome {
    //problem: Given a string s which consists of lowercase or uppercase letters, return the length of the longest
    // palindrome that can be built with those letters.
    //Letters are case sensitive, for example, "Aa" is not considered a palindrome.
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));//output: 7
    }

    public static int longestPalindrome(String s) {
        int longest = 0;
        int freq[] = new int[52];
        int oddExists = 0;
        int len = s.length();

        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            } else {
                freq[c - 'A' + 26]++;
            }
        }

        for (int i = 0; i < 52; i++){
            if ((freq[i] % 2) == 0){
                longest += freq[i];
            } else {
                longest += freq[i] - 1;
                oddExists = 1;
            }
        }

        return longest + oddExists;
    }
}
