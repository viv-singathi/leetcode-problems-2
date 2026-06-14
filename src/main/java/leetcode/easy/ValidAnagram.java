package leetcode.easy;

public class ValidAnagram {
    //problem: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    // An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    // using all the original letters exactly once.
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); //output: true
    }

    public static boolean isAnagram(String s, String t) {
        char freq[] = new char[26];

        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++){
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}
