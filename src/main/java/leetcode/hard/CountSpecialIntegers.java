package leetcode.hard;

public class CountSpecialIntegers {
    //problem: We call a positive integer special if all of its digits are distinct.
    //Given a positive integer n, return the number of special integers that belong to the interval [1, n].
    public static void main(String[] args) {
        System.out.println(countSpecialNumbers(225)); //output: 178
    }

    public static int countSpecialNumbers(int n) {
        if (n < 10) {return n;}

        int digits = (int) Math.log10(n) + 1;
        int special = 9;
        int prod = 9;

        for (int i = 1; i < digits-1; i++){
            prod = prod * (10 - i);
            special += prod;
        }

        //count same length

        int pow10 = (int) Math.pow(10, digits-1);
        int same = 0;
        int seen[] = new int[10];

        for (int i = 0; i < digits; i++){
            int d = (n / pow10) % 10;
            int usedLess = 0;


            for (int k = 0; k < d; k++){
                usedLess += seen[k];
            }

            if ((i > 0 && d > 0) || d > 1){

                int eq = d - usedLess - (i == 0 ? 1 : 0);
                for (int k = i+1; k < digits; k++){
                    eq *=  (10 - i - 1 - (k - (i+1)));
                }

                same += eq;
            }

            pow10 /= 10;
            seen[d]++;
            if (seen[d] > 1){
                break;
            }
        }

        special += same;
        int s = 0;

        for (int i = 0; i < 10; i++){
            s += seen[i];
            if (s > (i+1) || seen[i] > 1){
                special -= 1;
                break;
            }
        }

        special++;

        return special;
    }
}
