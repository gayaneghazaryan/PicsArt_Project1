package Comparator;

import Employee.Manager;

import java.util.Comparator;

public class RoleComparator implements Comparator<Manager> {
    @Override
    public int compare(Manager o1, Manager o2) {
        return o1.getRole().compareTo(o2.getRole());
    }
}
