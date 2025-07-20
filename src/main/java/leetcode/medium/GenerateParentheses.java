package leetcode.medium;
import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> combinations = generateParenthesis(3);

        for (String s : combinations){
            System.out.println(s);
        }

        //output:
        //((()))
        //(()())
        //(())()
        //()(())
        //()()()
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();

        makeCombinations(res, n, 0, 0, new char[n*2], 0);

        return res;
    }

    public static void makeCombinations(List<String> l, int n, int open, int closed, char current_combination[], int idx){

        if (idx >= current_combination.length){
            l.add(new String(current_combination));
        }

        if (open + 1 <= n){
            current_combination[idx] = '(';
            makeCombinations(l, n, open+1, closed, current_combination, idx+1);
        }

        if (closed + 1 <= open){
            current_combination[idx] = ')';
            makeCombinations(l, n, open, closed+1, current_combination, idx+1);
        }

    }
}
