package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> comb = combine(4, 2);

        for (List<Integer> l : comb){
            System.out.println(l.toString());
        }

        //output:
        //[1, 2]
        //[1, 3]
        //[1, 4]
        //[2, 3]
        //[2, 4]
        //[3, 4]

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinations(res, n, k, 1, new int[k], 0);

        return res;
    }

    public static void combinations(List<List<Integer>> l, int n, int k, int i, int current_combination[], int idx){
        if (idx >= k){

            List<Integer> copy = new ArrayList<Integer>(k);

            for (int v = 0; v < k; v++){
                copy.add(current_combination[v]);
            }

            l.add(copy);

            return;
        }

        int upper = -k + idx + 1 + n;

        for (int p = i; p <= upper; p++){

            // if (k - idx - 1 > n - p){
            //     return;
            // }

            current_combination[idx] = p;
            combinations(l, n, k, p+1, current_combination, idx+1);
        }
    }
}
