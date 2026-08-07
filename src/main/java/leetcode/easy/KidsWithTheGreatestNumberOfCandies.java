package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    //problem: There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
    // and an integer extraCandies, denoting the number of extra candies that you have.
    //Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
    // they will have the greatest number of candies among all the kids, or false otherwise
    public static void main(String[] args) {
        int c[] = {2,3,5,1,3};
        System.out.println(kidsWithCandies(c, 3)); //output: [true, true, true, false, true]
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<Boolean>(candies.length);
        int m = candies[0];

        for (int i = 1; i < candies.length; i++){
            m = Math.max(m, candies[i]);
        }

        for (int i = 0; i < candies.length; i++){
            res.add(candies[i] + extraCandies >= m);
        }

        return res;
    }
}
