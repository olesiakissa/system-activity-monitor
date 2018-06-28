package app;

import model.ProcessInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements {@code Iterator} object creation and returns the instance
 * of the concrete process iterator.
 */
public class ProcessAggregate implements Aggregate {

    private static List<ProcessInfo> processList = new ArrayList<>();

    public static void addProcessToList(ProcessInfo process) {
        processList.add(process);
    }

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
        @SuppressWarnings("unchecked")
        public ProcessInfo next() {
            if (this.hasNext()) {
                return processList.get(index++);
            }
            return null;
        }

    }

}