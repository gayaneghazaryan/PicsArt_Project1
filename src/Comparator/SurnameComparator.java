package Comparator;

import Employee.RestaurantEmployee;

import java.util.Comparator;

public class SurnameComparator implements Comparator<RestaurantEmployee> {
    @Override
    public int compare(RestaurantEmployee o1, RestaurantEmployee o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
