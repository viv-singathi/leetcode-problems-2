package leetcode.easy;

public class RansomNote {
    //problem: Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    //Each letter in magazine can only be used once in ransomNote
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab")); //output: true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int freq[] = new int[26];

        for (int i = 0; i < magazine.length(); i++){
            freq[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < ransomNote.length(); i++){
            freq[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (freq[i] > 0){
                return false;
            }
        }

        return true;
    }
}
