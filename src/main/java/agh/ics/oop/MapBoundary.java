package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Object> xAxis;
    SortedSet<Object> yAxis;
    IWorldMap map;
    public MapBoundary(IWorldMap map) {
        this.map = map;
        xAxis = new TreeSet<>(new CompareX());
        yAxis = new TreeSet<>(new CompareY());
    }
    public void addElement(Object object){
        xAxis.add(object);
        yAxis.add(object);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Object object = map.objectAt(newPosition);
        xAxis.remove(object);
        yAxis.remove(object);
        xAxis.add(object);
        yAxis.add(object);

    }
}
