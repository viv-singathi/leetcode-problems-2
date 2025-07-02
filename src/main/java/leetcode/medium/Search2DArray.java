package leetcode.medium;

public class Search2DArray {

    public  static void main(String args[]){
        int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(searchMatrix(arr, 3));
        //output: true

        System.out.println(searchMatrix(arr, 13));
        //output: false
    }

    public static boolean searchMatrix(int[][] matrix, int target){

        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = rows * cols - 1;

        do {
            int m = (i+j)/2;

            int c = m % cols;
            int r = (m - c)/cols;

            int sc = i % cols;
            int sr = (i - sc)/cols;

            int ec = j % cols;
            int er = (j - ec)/cols;

            if (matrix[r][c] == target || matrix[sr][sc] == target || matrix[er][ec] == target){
                return true;
            }

            if (matrix[r][c] < target){
                i = m;
            } else {
                j = m;
            }

        } while (i < j-1);

        return false;
    }
}
