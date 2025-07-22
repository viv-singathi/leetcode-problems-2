package leetcode.medium;

public class RemoveStarsFromString {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        //output: lecoe
    }

    public static String removeStars(String s) {
        char res[] = s.toCharArray();
        int len = 0;

        for (int i = 0;  i < res.length; i++){
            if (res[i] == '*'){
                len--;
            } else {
                res[len++] = res[i];
            }
        }

        return new String(res, 0, len);
    }
}
