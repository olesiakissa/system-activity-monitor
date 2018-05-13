package system.factory.creators;

import system.ProcessAggregate;

public class IteratorCreator implements Creator {

    /**
     * @return {@code Iterator} object to traverse the collection of processes.
     */
    @Override
    public Object createItem() {
        ProcessAggregate aggregate = new ProcessAggregate();
        return aggregate.createIterator();
    }

}
