package leetcode.medium;

public class CompressString {
    public static void main(String[] args) {
        char s[] = {'a','a','b','b','c','c','c'};
        int len = compress(s);

        for (int i = 0; i < len; i++){
            System.out.print(s[i]);
        }
        //output: a2b2c3
    }
    public static int compress(char[] chars) {

        int len = 0;
        int run_len = 1;

        for (int i = 1; i < chars.length; i++){

            if (chars[i] == chars[i-1]){
                run_len++;
            } else {

                chars[len++] = chars[i-1];

                if (run_len > 1){
                    len = writeNum(chars, len, run_len);
                }

                run_len = 1;
            }

        }

        chars[len++] = chars[chars.length-1];

        if (run_len > 1){
            len = writeNum(chars, len, run_len);
        }

        return len;
    }

    public static int writeNum(char arr[], int idx, int num){
        int pow = (int) Math.pow(10, (int) (Math.log10(num)));

        while (pow > 0){
            arr[idx++] = (char) (((num / pow) % 10) + '0');
            pow /= 10;
        }

        return idx;
    }
}
