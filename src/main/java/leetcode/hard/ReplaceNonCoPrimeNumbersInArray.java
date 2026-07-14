package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNonCoPrimeNumbersInArray {
    public static void main(String[] args) {
        int nums[] = {6,4,3,2,7,6,2};
        System.out.println(replaceNonCoprimes(nums)); //output: [12, 7, 6]

    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        int l = 1;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++){
            int current = nums[i];
            int d = gcd(prev, current);
            nums[l++] = current;

            while (d > 1 && l > 1){
                int lcm = prev * (current / d);
                l -= 2;
                nums[l++] = lcm;

                prev = l > 1 ? nums[l-2] : lcm;
                current = lcm;

                d = gcd(prev, current);
            }

            prev = current;
        }

        List<Integer> res = new ArrayList<Integer>(l);

        for (int i = 0; i < l; i++){
            res.add(nums[i]);
        }

        return res;
    }

    public static int gcd(int x, int y){
        if (y == 1){return 1;}
        if (x % y == 0) {return y;}
        return gcd(y, x % y);
    }

}
