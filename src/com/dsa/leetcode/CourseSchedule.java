package com.dsa.leetcode;

// https://leetcode.com/problems/course-schedule-iii/

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses));
        System.out.println(scheduleCourseBetterSolution(courses));
    }

    // O(n*n) time complexity and O(n) space complexity;
    private static int scheduleCourseBetterSolution(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                queue.add(course[0]);
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                time += course[0] - queue.poll();
                queue.add(course[0]);
            }
        }
        return queue.size();
    }

    // O(n*n) time complexity and O(1) space complexity;
    private static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int count = 0;
        int time = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                count++;
            } else {
                int max_i = i;
                for (int j = 0; j < i; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                    if (courses[max_i][0] > courses[i][0])
                        time += courses[i][0] - courses[max_i][0];
                }
            }
        }
        return count;
    }
}
