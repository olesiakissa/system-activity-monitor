package system;

import model.ProcessInfo;

import java.util.ArrayList;
import java.util.List;

public class ProcessAggregate implements Aggregate {

    List<ProcessInfo> processList = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ProcessIterator();
    }

    private class ProcessIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < processList.size();
        }

        @Override
        public Object next() {
            return processList.get(index++);
        }

    }

}
