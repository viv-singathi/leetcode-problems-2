package leetcode.medium;

public class TotalWavinessofNumbersInRange {
    //problem:
    //You are given two integers num1 and num2 representing an inclusive range [num1, num2].
    //The waviness of a number is defined as the total count of its peaks and valleys:
    //A digit is a peak if it is strictly greater than both of its immediate neighbors.
    //A digit is a valley if it is strictly less than both of its immediate neighbors.
    //The first and last digits of a number cannot be peaks or valleys.
    //Any number with fewer than 3 digits has a waviness of 0.
    //Return the total sum of waviness for all numbers in the range [num1, num2].
    public static void main(String[] args) {
        System.out.println(totalWaviness(120,  130)); //output: 3
    }

    public static int totalWaviness(int num1, int num2) {
        int count = 0;
        for (int i = num1; i <= num2; i++){
            int digits = 0;
            int t = i;

            while (t > 0){
                digits++;
                t /= 10 ;
            }

            int div = 10;
            for (int d = 1; d < digits-1; d++){
                int next = i / (div / 10) % 10;
                int prev = i / (div * 10) % 10;
                int current = i / div% 10;

                if (prev < current && current > next){count++;}
                if (prev > current && current < next){count++;}
                div *= 10;
            }
        }
        return count;
    }
}
