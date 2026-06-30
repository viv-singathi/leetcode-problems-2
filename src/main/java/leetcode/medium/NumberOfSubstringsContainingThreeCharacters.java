package leetcode.medium;

public class NumberOfSubstringsContainingThreeCharacters {
    //problem: Given a string s consisting only of characters a, b and c.
    //
    //Return the number of substrings containing at least one occurrence of all these characters a, b and c.
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc")); //output: 10
    }

    public static int numberOfSubstrings(String s) {
        int seen[] = new int[3];
        int l = 0;
        int u = -1;
        int substrings = 0;
        char str[] = s.toCharArray();

        while (true){
            if (seen[0] > 0 && seen[1] > 0 && seen[2] > 0){
                substrings += str.length - u;
                char c = str[l++];
                seen[c - 'a']--;
            } else {
                u++;
                if (u >= str.length){break;}
                char c = str[u];
                seen[c - 'a']++;
            }
        }

        return substrings;
    }
}
