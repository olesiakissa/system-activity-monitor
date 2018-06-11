package app.factory.creators;

/**
 * An abstraction for Creator in factory method.
 */
public interface Creator {

    <T> T createItem();

}
