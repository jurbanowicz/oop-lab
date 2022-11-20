package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> xAxis;
    SortedSet<Vector2d> yAxis;
    public MapBoundary() {
        xAxis = new TreeSet<>(new CompareX());
        yAxis = new TreeSet<>(new CompareY());
    }
    public void addElement(Vector2d vector){
        xAxis.add(vector);
        yAxis.add(vector);
    }
    public void removeElement(Vector2d vector) {
        xAxis.remove(vector);
        yAxis.remove(vector);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }
    public Vector2d upperRight() {
        return new Vector2d(xAxis.last().x, yAxis.last().y);
    }
    public Vector2d lowerLeft() {
        return new Vector2d(xAxis.first().x, yAxis.first().y);
    }
}
