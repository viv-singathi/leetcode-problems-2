package leetcode.medium;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvlo"));
        //output: vlvov
    }

    public static String reorganizeString(String s) {

        int freq[] = new int[26];
        char chars[] = s.toCharArray();

        for (int i = 0; i < chars.length; i++){
            freq[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++){
            int max_idx = -1;
            int max_freq = 0;

            for (int j = 0; j < 26; j++){
                if (freq[j] > max_freq && (i == 0 || (char) (j + 'a') != chars[i - 1])){
                    max_idx = j;
                    max_freq = freq[j];
                }
            }

            if (max_idx == -1){
                return "";
            }

            chars[i] = (char) (max_idx + 'a');
            freq[max_idx]--;
        }

        return new String(chars);
    }
}
