package leetcode.medium;

public class CountCollisionsOfMonkeyOnPolygon {
    //problem: There is a regular convex polygon with n vertices. The vertices are labeled from 0 to n - 1 in a clockwise direction, and each vertex has exactly one monkey.
    //Simultaneously, each monkey moves to a neighboring vertex. A collision happens if at least two monkeys reside on the same vertex after the movement or intersect on an edge.
    //Return the number of ways the monkeys can move so that at least one collision happens. Since the answer may be very large, return it modulo 109 + 7.
    public static void main(String[] args) {
        System.out.println(monkeyMove(4));//output: 14
    }

    public static long fpow(long x, int n){
        if (n == 0){return 1;}
        if (n % 2 == 1){return (x * fpow(x, n-1)) % 1000000007;}
        long r = fpow(x, n/2);
        return (r * r) % 1000000007;
    }

    public static int monkeyMove(int n) {
        int res = (int) (fpow(2, n) - 2) % 1000000007;
        return res >= 0 ? res : 1000000007 + res;
    }
}
