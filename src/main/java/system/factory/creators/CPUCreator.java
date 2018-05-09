package system.factory.creators;

import model.factory.products.CPU;
import model.factory.products.SystemItem;

public class CPUCreator implements SystemItemCreator {
    @Override
    public SystemItem createItem() {
        return new CPU();
    }
}
