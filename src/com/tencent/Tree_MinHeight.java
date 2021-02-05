package com.tencent;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zmd
 * @date 2021/2/5 20:38
 */
public class Tree_MinHeight {

    public static final int[][] edges = new int[][]{new int[]{1, 2},new int[]{0, 1},  new int[]{1, 3}};

    public static void main(String[] args) {

        int n = 4;

        int minHeight = Integer.MAX_VALUE;
        int minDot = -1;

        for (int i = 0; i < n; i++) {
            int height = height(i, Stream.iterate(1, e -> e).limit(n).toArray(e ->new Integer[e]));

            System.out.println("Dot: " + i);
            System.out.println("Height: " + height);
            System.out.println();

            if (minHeight > height) {
                minHeight = height;
                minDot = i;
            }
        }
        System.out.println("minDot: " + minDot);
        System.out.println("minHeight: " + minHeight);

    }


    public static int height(int n, Integer[] edgeIndex) {
        int minHeight = 0;

        for (int x = 0; x < edges.length; x++) {
            if (edgeIndex[x] == 0) {
                continue;
            }
            int dot;
            if (edges[x][0] == n) {
                dot = edges[x][1];
            } else if (edges[x][1] == n) {
                dot = edges[x][0];
            } else {
                continue;
            }
            final Integer[] edgeIndex1 = Arrays.copyOf(edgeIndex, edgeIndex.length);
            edgeIndex1[x] = 0;
            final int height1 = height(dot, edgeIndex1) + 1;
            if (minHeight== 0 || minHeight > height1) {
                minHeight = height1;
            }
        }
        return minHeight;

    }
}
