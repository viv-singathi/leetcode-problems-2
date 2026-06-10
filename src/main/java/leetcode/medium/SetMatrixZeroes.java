package leetcode.medium;

import java.util.Arrays;

public class SetMatrixZeroes {
    //problem:
    // Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
    //You must do it in place.
    public static void main(String[] args) {
        int mat[][] = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(mat);
        System.out.println(Arrays.toString(mat[0]));
        System.out.println(Arrays.toString(mat[1]));
        System.out.println(Arrays.toString(mat[2]));
        //output:
        //[1, 0, 1]
        //[0, 0, 0]
        //[1, 0, 1]
    }

    public static void setZeroes(int[][] matrix) {
        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;

        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                if (matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;

                    if (r == 0){
                        zeroFirstRow = true;
                    }
                    if (c == 0){
                        zeroFirstCol = true;
                    }

                }
            }
        }

        for (int r = 1; r < matrix.length; r++){
            if (matrix[r][0] == 0){
                for (int c = 1; c < matrix[0].length; c++){
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 1; c < matrix[0].length; c++){
            if (matrix[0][c] == 0){
                for(int r = 1; r < matrix.length; r++){
                    matrix[r][c] = 0;
                }
            }
        }

        if (zeroFirstRow){
            for (int c = 1; c < matrix[0].length; c++){
                matrix[0][c] = 0;
            }
        }

        if (zeroFirstCol){
            for (int r = 1; r < matrix.length; r++){
                matrix[r][0] = 0;
            }
        }

    }
}
