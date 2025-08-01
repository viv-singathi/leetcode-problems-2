package leetcode.easy;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
        System.out.println(canPermutePalindrome("aab"));

        //output:
        // false
        // true

    }

    public static boolean canPermutePalindrome(String s) {
        int freq[] = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++){
            freq[s.charAt(i) - 'a']++;
        }

        boolean oddExists = false;

        for (int i = 0; i < 26; i++){
            if (len % 2 == 0 && freq[i] % 2 != 0){
                return false;
            } else if (len % 2 == 1 && freq[i] % 2 != 0 && !oddExists){
                oddExists = true;
            } else if (len % 2 == 1 && freq[i] % 2 != 0 && oddExists) {
                return false;
            }

        }

        return true;

    }
}
