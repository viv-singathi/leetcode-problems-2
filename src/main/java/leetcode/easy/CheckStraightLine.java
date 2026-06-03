package leetcode.easy;

public class CheckStraightLine {
    //problem:
    // You are given an integer array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
    // Check if these points make a straight line in the XY plane
    public static void main(String[] args) {
        int points[][] = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {6,7}
        };
        System.out.println(checkStraightLine(points)); //output:true

    }


    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 2){return true;}

        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        int x = coordinates[0][0];
        int y = coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++){
            if ((coordinates[i][0] - x) * dy != (coordinates[i][1] - y) * dx){
                return false;
            }
        }

        return true;
    }

}
