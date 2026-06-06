package leetcode.easy;

public class MaximumScoreAfterSplittingString {
    //problem:
    //Given a string s of zeros and ones, return the maximum score after splitting the string into
    // two non-empty substrings (i.e. left substring and right substring).
    //The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
    public static void main(String[] args) {
        System.out.println(maxScore("011101")); //output: 5
    }

    public static int maxScore(String s) {
        int zeroes[] = new int[s.length()];
        char chars[] = s.toCharArray();
        int len = chars.length;

        zeroes[0] = chars[0] == '0' ? 1 : 0;

        for (int i = 1; i < len; i++){
            if (chars[i] == '0'){
                zeroes[i] = zeroes[i-1] + 1;
            } else {
                zeroes[i] = zeroes[i-1];
            }

        }
        int totalZeroes = zeroes[len-1];
        int max = zeroes[0] + (len - (totalZeroes - zeroes[0])-1);

        for (int i = 1; i < len - 1; i++){
            max = Math.max(max, zeroes[i] + (len - (totalZeroes - zeroes[i]) - i -1));
        }

        return max;
    }
}
