package agh.ics.oop;

import java.util.Comparator;

public class CompareX implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d v1, Vector2d v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        if (v1.x > v2.x) {
            return 1;
        } else if (v1.x < v2.x) {
            return -1;
        }
        else {
            if (v1.y > v2.y) {
                return 1;
            }
            else if (v1.y < v2.y) {
                return -1;
            }
        }
        return 0;
    }
}
