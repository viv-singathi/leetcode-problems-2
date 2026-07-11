package leetcode.easy;

import java.util.Arrays;

public class DistributeCandiesToPeople {
    //problem: We distribute some number of candies, to a row of n = num_people people in the following way:
    //We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
    //
    //Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person,
    // and so on until we give 2 * n candies to the last person.
    //This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.
    // The last person will receive all of our remaining candies.
    //Return an array (of length num_people and sum candies) that represents the final distribution of candies

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10, 3))); //output: [5, 2, 3]
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int res[] = new int[num_people];
        int N = (int) (-0.5 + Math.sqrt(0.25 + 2 * candies));
        int n = N / num_people;

        for (int i = 0; i < num_people; i++){
            res[i] = n * (i+1) + (n-1) * n * num_people / 2;
        }

        N = n * num_people;
        candies -= N * (N + 1) / 2;

        for (int i = 0; i < num_people; i++){
            if (candies >=  N + i + 1){
                res[i] += N + i + 1;
                candies -= N + i + 1;
            } else {
                res[i] += candies;
                candies = 0;
                break;
            }

        }

        return res;
    }
}
