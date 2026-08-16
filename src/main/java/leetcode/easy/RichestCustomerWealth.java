package leetcode.easy;

public class RichestCustomerWealth {
    //problem: You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank. Return the wealth that the richest customer has.
    //A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth
    public static void main(String[] args) {
        int accounts[][] = {{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(accounts)); //output: 10
    }

    public static int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0; i < accounts.length; i++){
            int s = 0;
            for (int j = 0; j < accounts[0].length; j++){
                s += accounts[i][j];
            }
            max = Math.max(max, s);
        }

        return max;
    }
}
