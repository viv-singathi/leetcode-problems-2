package leetcode.easy;

public class ToLowerCase {
    //problem: Given a string s, return the string after replacing every uppercase letter with the same lowercase letter
    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello")); //output: hello
    }

    public static String toLowerCase(String s) {
        char res[] = new char[s.length()];

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z'){
                res[i] = (char) (c - 'A' + 'a');
            } else {
                res[i] = c;
            }
        }

        return new String(res);
    }
}
