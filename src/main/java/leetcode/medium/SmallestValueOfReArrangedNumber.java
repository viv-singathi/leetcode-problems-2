package leetcode.medium;

public class SmallestValueOfReArrangedNumber {
    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
        System.out.println(smallestNumber(-7605));

        //output:
        // 103
        //-7650


    }

    public static long smallestNumber(long num) {
        long absn = Math.abs(num);
        int digits = (int) Math.log10(absn) + 1;

        long base = 1;
        int digit_freq[] = new int[10];

        for (int i = 0; i < digits; i++){
            int d = (int) ((absn/base) % 10);
            digit_freq[d]++;
            base *= 10;
        }

        if (num >= 0){
            return findMin(digit_freq);
        }

        return -findMax(digit_freq);
    }

    public static long findMin(int digit_freq[]){
        long res = 0;
        for (int i = 1; i < 10; i++){
            if (digit_freq[i] != 0){
                res += i;
                digit_freq[i]--;
                break;
            }
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < digit_freq[i]; j++){
                res = res * 10 + i;
            }
        }

        return res;
    }

    public static long findMax(int digit_freq[]){
        long res = 0;

        for (int i = 9; i > -1; i--){
            if (digit_freq[i] != 0){
                res += i;
                digit_freq[i]--;
                break;
            }
        }

        for (int i = 9; i > -1; i--){
            for (int j = 0; j < digit_freq[i]; j++){
                res = res * 10 + i;
            }
        }

        return res;
    }
}
