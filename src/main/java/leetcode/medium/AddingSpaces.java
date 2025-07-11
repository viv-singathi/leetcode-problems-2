package leetcode.medium;

public class AddingSpaces {

    public static void main(String[] args) {
        int spaces[] = {1,5,7,9};
        System.out.println(addSpaces("icodeinpython", spaces));

        //output: i code in py thon
    }

    public static String addSpaces(String s, int[] spaces) {
        char res[] = new char[s.length() + spaces.length];
        int offset = 0;

        for (int i = 0; i < s.length(); i++){
            if (offset < spaces.length && spaces[offset] == i){
                res[i + offset++] = ' ';
            }

            res[i + offset] = s.charAt(i);
        }

        return new String(res);
    }

}
