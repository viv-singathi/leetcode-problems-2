package leetcode.easy;

public class CanPlaceFlowers {
    //problem: You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
    //
    //Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers
    // can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise

    public static void main(String[] args) {
        int flowerbed[] = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2)); //output: false
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1){
            return n == 0 || n == 1 && flowerbed[0] == 0;
        }

        if (flowerbed[0] != 1 && flowerbed[1] != 1){
            flowerbed[0] = 1;
            n--;
        }

        for (int i = 1; i < flowerbed.length-1; i++){
            if (flowerbed[i] + flowerbed[i-1] + flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }

        if (flowerbed[flowerbed.length-1] != 1 && flowerbed[flowerbed.length-2] != 1){
            n--;
        }

        return n <= 0;
    }
}
