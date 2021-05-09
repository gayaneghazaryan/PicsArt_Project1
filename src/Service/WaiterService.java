package Service;


import Comparator.HireDateComparator;
import Comparator.TipsComparator;
import Comparator.WageRateComparator;
import Comparator.WorkedHoursComparator;
import Employee.Waiter;
import FileManager.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WaiterService {

    public void writeNamesSortedByWageRates(ArrayList<Waiter> waiters) throws IOException {
        FileService.writeWithAppend("FileService\\waiterOutput.txt","Method #1\n");
        Collections.sort(waiters,new WageRateComparator());

        for(Waiter waiter : waiters) {
            FileService.writeWithAppend("FileService\\waiterOutput.txt", waiter.getName()+"\n");
        }
    }

    public void writeWaiterWithEarliestHireDate(ArrayList<Waiter> waiters) throws IOException {
        FileService.writeWithAppend("FileService\\waiterOutput.txt","Method #2\n");
        FileService.writeWithAppend("FileService\\waiterOutput.txt", Collections.min(waiters, new HireDateComparator()).toString()+"\n");
    }

    public void sortWaitersByTips(ArrayList<Waiter> waiters) throws IOException {
        FileService.writeWithAppend("FileService\\waiterOutput.txt","Method #3\n");
        Collections.sort(waiters, new TipsComparator());
        for(Waiter waiter: waiters) {
            FileService.writeWithAppend("FileService\\waiterOutput.txt", waiter.getFullName()+"\n");
        }
    }

    public void sortFemaleWaitersByReversedWorkedHours(ArrayList<Waiter> waiters) throws IOException {
        FileService.writeWithAppend("FileService\\waiterOutput.txt","Method #4\n");
        Collections.sort(waiters, new WorkedHoursComparator());
        for(Waiter waiter: waiters) {
            if(waiter.getGender() == 'f') {
                FileService.writeWithAppend("FileService\\waiterOutput.txt", (String.format("Full Name: %s, Monthly Pay: %.2f\n",waiter.getFullName(),waiter.getMonthlyPay())));
            }
        }
    }

}
