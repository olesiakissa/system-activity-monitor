package app;

import model.ProcessInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements {@code Iterator} object creation and returns the instance
 * of the concrete process iterator.
 */
public class ProcessAggregate implements Aggregate {

    public static List<ProcessInfo> processList = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ProcessIterator();
    }

    private class ProcessIterator implements Iterator<ProcessInfo> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < processList.size();
        }

        @Override
        public ProcessInfo next() {
            if (this.hasNext()) {
                return processList.get(index++);
            }
            return null;
        }

    }

}