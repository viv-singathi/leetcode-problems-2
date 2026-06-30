package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    //problem:Given an integer numRows, return the first numRows of Pascal's triangle.
    //
    //In Pascal's triangle, each number is the sum of the two numbers directly above

    public static void main(String[] args) {
        System.out.println(generate(5));
        //output:[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> prevRow = new ArrayList<Integer>();
        prevRow.add(1);
        res.add(prevRow);

        for (int r = 1; r < numRows; r++){
            List<Integer> row = new ArrayList<Integer>();

            row.add(1);

            for (int n = 1; n < r; n++){
                row.add(prevRow.get(n-1) + prevRow.get(n));
            }

            row.add(1);

            res.add(row);
            prevRow = row;
        }

        return res;
    }


}
