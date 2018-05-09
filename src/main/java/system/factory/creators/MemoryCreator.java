package system.factory.creators;

import model.factory.products.Memory;
import model.factory.products.SystemItem;

public class MemoryCreator implements SystemItemCreator {
    @Override
    public SystemItem createItem() {
        return new Memory();
    }
}
