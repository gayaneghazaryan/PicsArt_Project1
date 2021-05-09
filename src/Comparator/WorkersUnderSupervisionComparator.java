package Comparator;

import Employee.Manager;

import java.util.Comparator;

public class WorkersUnderSupervisionComparator implements Comparator<Manager> {
    @Override
    public int compare(Manager o1, Manager o2) {
        return o1.getNumberOfWorkersUnderSupervision() - o2.getNumberOfWorkersUnderSupervision();
    }
}
