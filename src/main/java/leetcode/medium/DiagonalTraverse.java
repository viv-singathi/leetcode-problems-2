package leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DiagonalTraverse {

    public static void main(String args[]){
        int mat[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        int res[] = findDiagonalOrder(mat);

        System.out.println(Arrays.toString(res));

        //output: [1, 2, 4, 7, 5, 3, 6, 8, 9]
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int diagonalOrder[] = new int[mat.length * mat[0].length];

        int k = 0;

        for (int i = 0; i < mat.length + mat[0].length; i++){
            int dx;
            int dy;

            int r;
            int c;

            if (i % 2 == 0){
                dx = 1;
                dy = -1;
                r = i < mat.length ? i : mat.length - 1;
                c = i - r;
            } else {
                dx = -1;
                dy = 1;
                c = i < mat[0].length - 1 ? i : mat[0].length - 1;
                r = i - c;
            }

            while (-1 < r && r < mat.length && - 1 < c && c < mat[0].length){
                diagonalOrder[k++] = mat[r][c];
//                System.out.print(r * mat[0].length + (c+1) + ", ");
                r += dy;
                c += dx;
            }

        }

        return diagonalOrder;
    }
}
