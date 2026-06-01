package leetcode.easy;

public class ToeplitzMatrix {
    //problem:
    //Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
    //A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
    public static void main(String[] args) {
        int mat[][] = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        System.out.println(isToeplitzMatrix(mat));//output: true
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            if (!sameDiagonal(matrix, i, 0)){
                return false;
            }
        }

        for (int j = 1; j < matrix[0].length; j++){
            if (!sameDiagonal(matrix, 0, j)){
                return false;
            }
        }

        return true;
    }

    public static boolean sameDiagonal(int[][] matrix, int i, int j){
        int iter = Math.min(matrix.length - i, matrix[0].length - j);
        int val = matrix[i][j];
        i++;
        j++;
        for (int t = 1; t < iter; t++){
            if (matrix[i][j] != val){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
