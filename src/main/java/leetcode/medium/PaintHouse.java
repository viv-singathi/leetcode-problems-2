package leetcode.medium;

public class PaintHouse {
    public static void main(String[] args) {
        int costs[][] = {
                {17,2,17},
                {16,16,5},
                {14,3,19}
        };

        System.out.println(minCost(costs));

        //output: 10
    }

    public static int minCost(int[][] costs) {

        for (int i = 1; i < costs.length; i++){
            int prev_costs[] = costs[i-1];
            costs[i][0] += prev_costs[1] < prev_costs[2] ? prev_costs[1] : prev_costs[2];
            costs[i][1] += prev_costs[2] < prev_costs[0] ? prev_costs[2] : prev_costs[0];
            costs[i][2] += prev_costs[0] < prev_costs[1] ? prev_costs[0] : prev_costs[1];
        }

        int last[] = costs[costs.length-1];
        return Math.min(last[0], Math.min(last[1], last[2]));
    }
}
