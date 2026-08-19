package leetcode.easy;

public class WaterBottles {
    //problem: There are numBottles water bottles that are initially full of water.
    //You can exchange numExchange empty water bottles from the market with one full water bottle.
    //The operation of drinking a full water bottle turns it into an empty bottle.
    //Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4)); //output: 19
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange){
            numBottles = emptyBottles / numExchange;
            n += numBottles;
            emptyBottles = (emptyBottles % numExchange) + numBottles;
        }

        return n;
    }
}
