package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeroes {
    public static void main(String[] args) {
        List<String> res = validStrings(3);
        System.out.println(res.toString());
        //output: [010, 011, 101, 110, 111]
    }

    public static List<String> validStrings(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0){return res;}
        generateStrings(res, new char[n], 0);
        return res;
    }

    public static void generateStrings(List<String> l, char current_string[], int idx){
        if (idx >= current_string.length){
            l.add(new String(current_string));
            return;
        }

        if (idx == 0 || current_string[idx-1] != '0'){
            current_string[idx] = '0';
            generateStrings(l, current_string, idx+1);
        }

        current_string[idx] = '1';
        generateStrings(l, current_string, idx+1);
    }
}
