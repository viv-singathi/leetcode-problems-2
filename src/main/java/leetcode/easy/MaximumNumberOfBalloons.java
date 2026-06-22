package leetcode.easy;

public class MaximumNumberOfBalloons {
    //problem: Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
    //You can use each character in text at most once. Return the maximum number of instances that can be formed.
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon")); //output: 2
    }

    public static int maxNumberOfBalloons(String text) {
        int freq[] = new int[26];
        int l = text.length();

        for (int i = 0; i < l; i++){
            freq[text.charAt(i) - 'a']++;
        }

        int times = Math.min(freq['b'-'a'], freq['a' - 'a']);
        times = Math.min(times, freq['l'-'a']/2);
        times = Math.min(times, freq['o'-'a']/2);
        times = Math.min(times, freq['n'-'a']);

        return times;
    }
}
