package leetcode.medium;

public class AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        //output: 165.0
    }

    public static double angleClock(int hour, int minutes) {

        double min = minutes * 6;
        double h = (hour * 30 + minutes/2.0) % 360;

        return Math.min(Math.abs(h - min), 360 - Math.abs(h - min));
    }
}
