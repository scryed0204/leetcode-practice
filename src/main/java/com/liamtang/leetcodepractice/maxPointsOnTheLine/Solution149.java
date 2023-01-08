package com.liamtang.leetcodepractice.maxPointsOnTheLine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1)
            return 1;

        int result = 2;

        for(int i = 0; i < n; i++) {
            Map<Double, Integer> cntMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    double slope = Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                    if (cntMap.get(slope) != null) {
                        int val = cntMap.get(slope);
                        cntMap.put(slope, val + 1);
                    } else {
                        cntMap.put(slope, 1);
                    }
                }
                if (!cntMap.isEmpty())
                {
                    result = Math.max(result, Collections.max(cntMap.values()) + 1);
                }

            }
        }
        return result;
    }

    public static void main(String[] Args) {
        int[][] points = { { 2, 7 }, { 4, 5 }, { 3, 6}, { 7, 4} };
        //System.out.println(points.length);
        Solution149 solution = new Solution149();
        System.out.println(solution.maxPoints(points));

    }
}
