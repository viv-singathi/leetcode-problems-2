package leetcode.medium;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));

        //output:
        // true
        // false
    }

    public static boolean isRobotBounded(String instructions) {
        int re = 0;
        int im = 0;

        char m[] = instructions.toCharArray();
        int look_re = 0;
        int look_im = 1;
        char d;

        for (int i = 0; i < m.length; i++){
            d = m[i];

            if (d == 'L'){
                int tmp = look_re;
                look_re = -look_im;
                look_im = tmp;
            } else if (d == 'R'){
                int tmp = look_re;
                look_re = look_im;
                look_im = -tmp;
            } else {
                re += look_re;
                im += look_im;
            }
        }

        return (re == 0 && im == 0 || look_re != 0 || look_im != 1);
    }
}
