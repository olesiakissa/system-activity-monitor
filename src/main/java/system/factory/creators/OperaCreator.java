package system.factory.creators;

import model.factory.products.Opera;
import model.factory.products.SystemItem;

public class OperaCreator implements BrowserCreator {
    @Override
    public SystemItem createItem() {
        return new Opera();
    }
}
