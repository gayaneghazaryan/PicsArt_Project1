package Comparator;

import Employee.RestaurantEmployee;

import java.util.Comparator;

public class ExperienceComparator implements Comparator<RestaurantEmployee> {

    @Override
    public int compare(RestaurantEmployee o1, RestaurantEmployee o2) {
        return (int)(o1.getExperience() - o2.getExperience());
    }
}
