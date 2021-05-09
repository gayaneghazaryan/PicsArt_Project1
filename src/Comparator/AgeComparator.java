package Comparator;

import Employee.RestaurantEmployee;

import java.util.Comparator;

public class AgeComparator implements Comparator<RestaurantEmployee> {

    @Override
    public int compare(RestaurantEmployee o1, RestaurantEmployee o2) {
        return o1.getAge() - o2.getAge();
    }
}
