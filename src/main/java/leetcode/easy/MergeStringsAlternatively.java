package leetcode.easy;

public class MergeStringsAlternatively {
    //problem: You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
    // If a string is longer than the other, append the additional letters onto the end of the merged string.
    //Return the merged string

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr")); //output: apbqcr
    }

    public static String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        char res[] = new char[word1.length() + word2.length()];

        for (int i = 0; i < len; i++){
            res[2 * i] = word1.charAt(i);
            res[2 * i + 1] = word2.charAt(i);
        }

        String longer = word1.length() > word2.length() ? word1 : word2;

        for (int i = len; i < longer.length(); i++){
            res[len + i] = longer.charAt(i);
        }

        return new String(res);
    }


}
