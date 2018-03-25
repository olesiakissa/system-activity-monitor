package system;

/**
 * An iterator over a collection.
 */
public interface Iterator {

    /**
     * @return {@code true} - if the collection has more elements
     */
    boolean hasNext();

    /**
     * @return the next object of collection
     */
    Object next();

}