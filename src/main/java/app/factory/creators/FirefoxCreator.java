package app.factory.creators;

import model.factory.products.Firefox;
import model.factory.products.SystemItem;

public class FirefoxCreator implements BrowserCreator {

    @Override
    public SystemItem createItem() {
        return new Firefox();
    }

}