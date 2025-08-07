package leetcode.medium;

public class StringCompressionIII {

    public static void main(String[] args) {
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
        System.out.println(compressedString("abcde"));

        //output:
        // 9a5a2b
        //1a1b1c1d1e
    }

    public static String compressedString(String word) {
        StringBuilder buff = new StringBuilder();
        char s[] = word.toCharArray();

        int run_len = 1;

        for (int i = 1; i < s.length; i++){

            if (s[i] != s[i-1] || run_len >= 9){
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
