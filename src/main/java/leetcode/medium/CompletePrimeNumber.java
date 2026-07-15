package leetcode.medium;

public class CompletePrimeNumber {
    //problem: You are given an integer num.
    //A number num is called a Complete Prime Number if every prefix and every suffix of num is prime.
    //Return true if num is a Complete Prime Number, otherwise return false
    public static void main(String[] args) {
        System.out.println(completePrime(23)); //output: true
    }

    public static boolean completePrime(int num) {
        int digits = (int) (1 + Math.log10(num));
        int pow10 = (int) Math.pow(10, digits-1);
        int pow210 = 1;

        int pre = 0;
        int suf = 0;

        for (int d = 0; d < digits; d++){
            pre = pre * 10 + ((num / pow10) % 10);
            suf = suf + pow210 * ((num / pow210) % 10);

            if (!isPrime(pre) || !isPrime(suf)){return false;}

            pow10 /= 10;
            pow210 *= 10;
        }

        return true;
    }

    public static boolean isPrime(int n){
        if (n == 1){return false;}
        int sqrtn = 1 + (int) Math.sqrt(n);
        for (int i = 2; i < sqrtn; i++){
            if (n % i == 0){return false;}
        }

        return true;
    }
}
