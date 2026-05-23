package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle  = new ArrayList<List<Integer>>();

        ArrayList<Integer> L1 = new ArrayList<>();
        L1.add(2);
        ArrayList<Integer> L2 = new ArrayList<>();
        L2.add(3);
        L2.add(4);
        ArrayList<Integer> L3 = new ArrayList<>();
        L3.add(6);
        L3.add(5);
        L3.add(7);
        ArrayList<Integer> L4 = new ArrayList<>();
        L4.add(4);
        L4.add(1);
        L4.add(8);
        L4.add(3);

        triangle.add(L1);
        triangle.add(L2);
        triangle.add(L3);
        triangle.add(L4);

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int min[] = new int[1];
        min[0] = triangle.get(0).get(0);

        for (int i = 1; i < h; i++){
            int newMin[] = new int[i+1];
            List<Integer> level = triangle.get(i);
            for (int j = 0; j <= i; j++){
                int val = level.get(j);
                int leftIndex = j > 0 ? j-1 : 0;
                int aboveIndex = j < i ? j : i-1;
                newMin[j] = Math.min(val + min[leftIndex], val + min[aboveIndex]);
            }
            min = newMin;
        }

        int minFound = min[0];

        for (int j = 1; j < min.length; j++){
            if (min[j] < minFound){
                minFound = min[j];
            }
        }

        return minFound;
    }
}
