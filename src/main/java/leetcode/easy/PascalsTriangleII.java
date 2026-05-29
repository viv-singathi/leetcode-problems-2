package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    //problem:
    //Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
    public static void main(String[] args) {
        System.out.println(getRow(4)); //output: [1, 4, 6, 4, 1]
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        long n = 1;
        long mult = rowIndex;

        for (int i = 0; i <= rowIndex; i++){
            res.add((int) n);
            n = n * mult / (i+1);
            mult--;
        }

        return res;
    }
}
