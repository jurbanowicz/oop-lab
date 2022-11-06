package agh.ics.oop;

public abstract class AbstractWorldMap implements IWorldMap {
   /*
   Ze względu na znacząco inny sposób implementacji rectangular map oraz grass field, w tych klasach nie pojawia się kod wspólny i
   nie byłem w stanie prenieść implemetnacji metod z interfejsu do bieżącej klasy.
   */
    public String toString(){
        MapVisualizer visual = new MapVisualizer(this);
        return visual.draw(findLowLeft(), findUpperRight());
    }
    public abstract Vector2d findLowLeft();

    public abstract Vector2d findUpperRight();

    public abstract boolean canMoveTo(Vector2d position);

    public abstract boolean place(Animal animal);

    public abstract boolean isOccupied(Vector2d position);

}
