package Comparator;

import Employee.Waiter;

import java.util.Comparator;

public class TipsComparator implements Comparator<Waiter> {
    @Override
    public int compare(Waiter o1, Waiter o2) {
        return (int)(o1.getTips() - o2.getTips());
    }
}
