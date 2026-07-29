package leetcode.medium;

public class JumpGameVII {
    //problem: You are given a 0-indexed binary string s and two integers minJump and maxJump.
    // In the beginning, you are standing at index 0, which is equal to '0'.
    // You can move from index i to index j if the following conditions are fulfilled:
    //i + minJump <= j <= min(i + maxJump, s.length - 1), and
    //s[j] == '0'.
    //Return true if you can reach index s.length - 1 in s, or false otherwise

    public static void main(String[] args) {
        System.out.println(canReach("011010", 2, 3)); //output: true
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int l = s.length();
        int currentIdx = 0;
        int nextStart = minJump;
        int nextEnd = maxJump;

        while (nextStart <= nextEnd){
            int newStart = -1;
            int newEnd = currentIdx + maxJump;

            for (int i = nextStart; i <= nextEnd; i++){
                if (s.charAt(i) == '0'){
                    currentIdx = i;
                    newEnd = i + maxJump;

                    if (newStart == -1 && i + minJump > nextEnd){
                        newStart = i + minJump;
                    } else if (newStart == -1){
                        newStart = nextEnd+1;
                    }

                }
            }

            newEnd = Math.min(newEnd, l-1);

            if (newStart == -1){
                return false;
            }
            nextEnd = newEnd;
            nextStart = newStart;
        }

        return currentIdx == l-1;
    }
}
