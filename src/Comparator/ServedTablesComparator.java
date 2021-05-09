package Comparator;

import Employee.Waiter;

import java.util.Comparator;

public class ServedTablesComparator implements Comparator<Waiter> {
    @Override
    public int compare(Waiter o1, Waiter o2) {
        return o1.getNumberOfServedTables() - o2.getNumberOfServedTables();
    }
}
