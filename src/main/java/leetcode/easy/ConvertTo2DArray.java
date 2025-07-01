package leetcode.easy;

import java.util.Arrays;

public class ConvertTo2DArray {

    public  static  void main(String args[]){
        int original[] = {1,2,3,4};
        int arr[][] = construct2DArray(original, 2, 2);

        for (int i = 0; i  < 2; i++){
            for (int j = 0; j < 2; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

        //output: 1 2
        //        3 4
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {

        if (m * n != original.length) { return new int[0][0]; }

        int matrix[][] = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = original[i * n + j];
            }
        }

        return matrix;
    }
}
