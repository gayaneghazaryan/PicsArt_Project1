package Comparator;

import Employee.RestaurantEmployee;

import java.util.Comparator;

public class NameComparator implements Comparator<RestaurantEmployee> {
    @Override
    public int compare(RestaurantEmployee o1, RestaurantEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
