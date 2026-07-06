package leetcode.easy;

public class DistanceBetweenBusStops {
    //problem: A bus has n stops numbered from 0 to n - 1 that form a circle.
    // We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
    //The bus goes along both directions i.e. clockwise and counterclockwise.
    //Return the shortest distance between the given start and destination stops.
    public static void main(String[] args) {
        int dist[] = {1,2,3,4};
        System.out.println(distanceBetweenBusStops(dist, 0, 2)); //output: 3
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination){
            int tmp = start;
            start = destination;
            destination = tmp;
        }

        int d1 = 0;

        for (int i = start; i < destination; i++){
            d1 += distance[i];
        }

        int s = 0;

        for (int i = 0; i < distance.length; i++){
            s += distance[i];
        }

        return Math.min(d1, s - d1);
    }
}
