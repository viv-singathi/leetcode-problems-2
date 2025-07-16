package leetcode;

import java.util.Arrays;

public class SparseMatrixMultiplication {
    public static void main(String[] args) {
        int m1[][] = {
                {1,0,0},
                {-1,0,3}
        };
        int m2[][] = {
                {7,0,0},
                {0,0,0},
                {0,0,1}
        };

        int res[][] = multiply(m1, m2);

        for (int row = 0; row < res.length; row++){
            System.out.println(Arrays.toString(res[row]));
        }

        //output: [7, 0, 0]
        //        [-7, 0, 3]
    }

    public static int[][] multiply(int[][] mat1, int[][] mat2){
        int M[][] = new int[mat1.length][mat2[0].length];

        boolean M1RowZeroes[] = new boolean[mat1.length];

        for (int i = 0; i < mat1.length; i++){
            M1RowZeroes[i] = true;
            for (int j = 0; j < mat1[0].length; j++){
                if (mat1[i][j] != 0){
                    M1RowZeroes[i] = false;
                    break;
                }
            }
        }

        for (int i = 0; i < M.length; i++){

            if (M1RowZeroes[i]){
                continue;
            }

            for (int k = 0; k < mat2.length; k++){

                for (int j = 0; j < M[0].length; j++){

                    if (mat1[i][k] == 0 || mat2[k][j] == 0){
                        continue;
                    }

                    M[i][j] += mat1[i][k] * mat2[k][j];
                }

            }
        }

        return M;
    }
}
