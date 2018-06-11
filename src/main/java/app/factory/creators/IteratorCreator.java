package app.factory.creators;

import app.Iterator;
import app.ProcessAggregate;

public class IteratorCreator implements Creator {

    /**
     * @return {@code Iterator} object to traverse the collection of processes.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Iterator createItem() {
        ProcessAggregate aggregate = new ProcessAggregate();
        return aggregate.createIterator();
    }

}
