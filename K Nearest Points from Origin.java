package com.xiangpengli;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NearestPoint {


    public List<Point> kNearestPoints(List<Point> points, int k) {
        List<Point> res = new ArrayList<>();
        if (points == null || points.size() == 0) {
            return res;
        }

        Point origin = new Point(0, 0);
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((o1, o2) -> {
            int dis1 = NearestPoint.this.distance(o1, origin);
            int dis2 = NearestPoint.this.distance(o2, origin);
            return dis2 - dis1;
        });
        for (Point p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll());
        }

        return res;

    }

    private int distance(Point x, Point origin) {
        return (x.x - origin.x) * (x.x - origin.x)
                + (x.y - origin.y) * (x.y - origin.y);

    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}