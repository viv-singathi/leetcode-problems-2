package leetcode.medium;

public class OptimalSubstringPartion {

    public static  void main(String args[]){
        System.out.println(partitionString("abacaba"));
        // output: 4
        System.out.println(partitionString("ssssss"));
        // output: 6
    }

    public static int partitionString(String s) {

        boolean seen[] = new boolean[26];
        int n = 1;

        int p = 0;
        int mapped_elements[] = new int[26];

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (seen[c - 'a']){

                for (int k = 0; k < p; k++){
                    seen[mapped_elements[k]] = false;
                }

                mapped_elements[0] = c - 'a';
                p = 1;

                seen[c - 'a'] = true;
                n++;
            } else {
                seen[c - 'a'] = true;
                mapped_elements[p++] = c - 'a';
            }
        }

        return n;
    }
}
