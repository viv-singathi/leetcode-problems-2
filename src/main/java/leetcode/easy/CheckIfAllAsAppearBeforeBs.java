package leetcode.easy;

public class CheckIfAllAsAppearBeforeBs {
    //problem: Given a string s consisting of only the characters 'a' and 'b',
    // return true if every 'a' appears before every 'b' in the string. Otherwise, return false.
    public static void main(String[] args) {
        System.out.println(checkString("aaabbb")); //output: true
    }

    public static boolean checkString(String s) {
        int i = 0;
        int l = s.length();

        while (i < l && s.charAt(i) == 'a'){
            i++;
        }

        for (; i < l; i++){
            if (s.charAt(i) != 'b'){
                return false;
            }
        }

        return true;

    }


}
