package system.factory.creators;

import model.factory.products.Chrome;
import model.factory.products.SystemItem;

public class ChromeCreator implements BrowserCreator {

    @Override
    public SystemItem createItem() {
        return new Chrome();
    }

}
