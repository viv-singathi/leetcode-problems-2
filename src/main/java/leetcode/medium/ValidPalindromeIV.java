package leetcode.medium;

public class ValidPalindromeIV {
    public static void main(String args[]){

        System.out.println(makePalindrome("abcdba"));
        System.out.println(makePalindrome("abcdef"));

        //output:
        // true
        // false

    }

    public static boolean makePalindrome(String s) {
        char str[] = s.toCharArray();
        int len = str.length;
        int j = len-1;
        char invalid = 0;

        for (int i = 0; i < len/2; i++){
            if (str[i] != str[j--]){
                invalid++;
                if (invalid > 2){
                    return false;
                }
            }
        }

        return true;
    }
}
