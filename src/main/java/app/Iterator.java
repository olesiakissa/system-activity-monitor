package app;

/**
 * An iterator over a collection for accessing and traversing elements.
 */
public interface Iterator {

    /**
     * @return {@code true} - if the collection has more elements
     */
    boolean hasNext();

    /**
     * @return the next object of collection
     */
    <T> T next();

}