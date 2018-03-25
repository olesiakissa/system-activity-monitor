package system;

import model.ProcessInfo;

public class App {
    public static void main(String[] args) {
        ProcessAggregate aggregate = new ProcessAggregate();
        aggregate.processList.add(new ProcessInfo(1, 1, "command1", "name1", "owner1"));
        aggregate.processList.add(new ProcessInfo(2, 2, "command2", "name2", "owner2"));
        aggregate.processList.add(new ProcessInfo(3, 3, "command3", "name3", "owner3"));
        Iterator iterator = aggregate.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
