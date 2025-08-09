package leetcode.medium;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        //output: 1211
    }

    public static String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++){
            s = RLE(s.toCharArray());
        }

        return s;
    }

    public static String RLE(char s[]){
        StringBuilder buff = new StringBuilder();

        int run_len = 1;

        for (int i = 1; i < s.length; i++){
            if (s[i] != s[i-1]){
                buff.append((char) ('0' + run_len));
                buff.append(s[i-1]);
                run_len = 1;
            } else {
                run_len++;
            }
        }

        buff.append((char) ('0' + run_len));
        buff.append(s[s.length-1]);


        return buff.toString();
    }
}
