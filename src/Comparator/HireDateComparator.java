package Comparator;

import Employee.RestaurantEmployee;

import java.util.Comparator;

public class HireDateComparator implements Comparator<RestaurantEmployee> {
    @Override
    public int compare(RestaurantEmployee o1, RestaurantEmployee o2) {
        return o1.getHireDate().compareTo(o2.getHireDate());
    }
}
