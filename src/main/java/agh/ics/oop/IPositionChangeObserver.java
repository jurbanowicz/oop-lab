package agh.ics.oop;

public interface IPositionChangeObserver {
    /** updates the position of the animal on the map
     *
     * @param oldPosition old position of the animal
     * @param newPosition new position of the animal
     */
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
