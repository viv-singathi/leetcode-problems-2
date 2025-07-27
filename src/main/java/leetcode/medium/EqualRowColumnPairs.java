package leetcode.medium;

public class EqualRowColumnPairs {

    public static void main(String[] args) {
        int mat[][] = {
                {3,2,1},
                {1,7,6},
                {2,7,7}
        };

        System.out.println(equalPairs(mat));

        //output: 1
    }

    public static int equalPairs(int[][] grid) {

        int equals = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){

                boolean equal = true;

                for (int i = 0; i < rows; i++){
                    if (grid[r][i] != grid[i][c]){
                        equal = false;
                        break;
                    }
                }

                if (equal){
                    equals++;
                }

            }
        }

        return equals;

    }
}
