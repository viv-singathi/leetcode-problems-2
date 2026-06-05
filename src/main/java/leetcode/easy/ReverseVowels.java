package leetcode.easy;

public class ReverseVowels {
    //problem:
    //Given a string s, reverse only all the vowels in the string and return it.
    //The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm")); //output: AceCreIm
    }
    public static String reverseVowels(String s) {
        char res[] = s.toCharArray();
        int l = 0;
        int u = s.length()-1;

        while (l < u){
            if (!isVowel(res[l])){
                l++;
            } else if (!isVowel(res[u])){
                u--;
            } else{
                char tmp = res[l];
                res[l++] = res[u];
                res[u--] = tmp;
            }
        }
        return new String(res);
    }

    public static boolean isVowel(char c){
        if (c < 'a') {c = (char) (c - 'A' + 'a');}
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
