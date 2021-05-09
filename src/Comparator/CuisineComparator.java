package Comparator;

import Employee.Chef;

import java.util.Comparator;

public class CuisineComparator implements Comparator<Chef> {
    @Override
    public int compare(Chef o1, Chef o2) {
        return o1.getCuisine().compareTo(o2.getCuisine());
    }
}
