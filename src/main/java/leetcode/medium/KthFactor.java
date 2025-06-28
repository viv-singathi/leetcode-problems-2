package leetcode.medium;

public class KthFactor {
    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));


    }

    public static int kthFactor(int n, int k) {
        int i = 0;
        int factor = 0;

        while (i++ < n){
            if (n % i == 0){
                factor++;
            }

            if (factor == k){
                return i;
            }
        }

        return -1;
    }


}
