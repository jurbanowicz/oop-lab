package agh.ics.oop;

public interface IMapObserver {

    /**
     * Informs the GUI that map has been changed and GUI should be rendered again
     */
    public void positionChanged();
}
