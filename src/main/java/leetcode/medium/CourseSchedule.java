package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    //problem: There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi]
    // indicates that you must take course bi first if you want to take course ai.
    //For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    //Return true if you can finish all courses. Otherwise, return false

    public static void main(String[] args) {
        int prereqs[][] = {{1,0},{0,1}};
        System.out.println(canFinish(2, prereqs));//output: false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List postreqs[] = new List[numCourses];
        int prereqsLeft[] = new int[numCourses];
        int finished[] = new int[numCourses];
        int f = 0;

        for (int i = 0; i < numCourses; i++){
            postreqs[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++){
            int prereq[] = prerequisites[i];
            postreqs[prereq[0]].add(prereq[1]);
            prereqsLeft[prereq[1]]++;
        }

        for (int i = 0; i < prereqsLeft.length; i++){
            if (prereqsLeft[i] == 0){
                prereqsLeft[i] = -1;
                finished[f++] = i;
            }
        }

        for (int j = 0; j < f; j++){
            int finishedCourse = finished[j];
            List<Integer> post = postreqs[finishedCourse];

            for (Integer c : post){
                prereqsLeft[c]--;
                if (prereqsLeft[c] == 0){
                    prereqsLeft[c] = -1;
                    finished[f++] = c;
                }
            }

        }

        return f == numCourses;
    }
}
