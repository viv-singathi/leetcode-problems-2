package leetcode.medium;

public class DecodeString {

    public static void main(String args[]){
        System.out.println(decodeString("3[a]2[bc]"));
        //output: aaabcbc

        System.out.println(decodeString("3[a2[c]]"));
        //output: accaccacc
    }

    public static String decodeString(String s) {
        StringBuffer buff = new StringBuffer();
        parseBrackets(s.toCharArray(), 0, buff);

        return buff.toString();
    }

    public static int parseBrackets(char s[], int idx, StringBuffer buff){

        char c;
        int n = 0;

        while (idx < s.length){
            c = s[idx++];

            if ('0' <= c && c <= '9'){

                n = n * 10 + (c - '0');

            } else if (c == '['){

                StringBuffer decoded = new StringBuffer();
                idx = parseBrackets(s, idx, decoded);
                char tmp[] = decoded.toString().toCharArray();

                for (int i = 0; i < n; i++){
                    for (int p = 0; p < tmp.length; p++){
                        buff.append(tmp[p]);
                    }
                }

                n = 0;

            } else if (c == ']'){
                return idx;
            } else {
                buff.append(c);
            }

        }

        return idx;
    }
}
