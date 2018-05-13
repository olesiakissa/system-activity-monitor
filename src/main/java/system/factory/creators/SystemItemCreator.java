package system.factory.creators;

import model.factory.products.SystemItem;

/**
 * Interface for creating system objects.
 */
public interface SystemItemCreator extends Creator {

    SystemItem createItem();

}
