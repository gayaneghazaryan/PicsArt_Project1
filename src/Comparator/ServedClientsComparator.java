package Comparator;

import Employee.Bartender;

import java.util.Comparator;

public class ServedClientsComparator implements Comparator<Bartender> {
    @Override
    public int compare(Bartender o1, Bartender o2) {
        return o1.getNumberOfServedClients() - o2.getNumberOfServedClients();
    }
}
