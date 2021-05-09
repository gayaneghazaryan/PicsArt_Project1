package Service;


import Comparator.AgeComparator;
import Comparator.RoleComparator;
import Comparator.SalaryComparator;
import Comparator.WorkersUnderSupervisionComparator;
import Employee.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static FileManager.FileService.writeWithAppend;

public class ManagerService {

    public void writeSurnamesSortedByAgeWhoAreOlderThan25(ArrayList<Manager> managers) throws IOException {
        writeWithAppend("FileService\\managerOutput.txt","Method #1\n");
        Collections.sort(managers,new AgeComparator());
        for(Manager manager: managers) {
            if(manager.getAge() > 25) {
                writeWithAppend("FileService\\managerOutput.txt",manager.getSurname()+"\n");
            }
        }
    }

    public void writeManagerWithLowestSalary(ArrayList<Manager> managers) throws IOException {
        writeWithAppend("FileService\\managerOutput.txt", "Method #2\n");
        writeWithAppend("FileService\\managerOutput.txt", Collections.min(managers,new SalaryComparator()).toString()+"\n");
    }

    public void sortManagersByReversedNumbersOfWorkersUnderSupervision(ArrayList<Manager> managers) throws IOException {
        writeWithAppend("FileService\\managerOutput.txt", "Method #3\n");

        Collections.sort(managers,new WorkersUnderSupervisionComparator().reversed());
        for(Manager manager: managers) {
            writeWithAppend("FileService\\managerOutput.txt",manager.toString()+"\n");
        }
    }

    public void sortManagersBySpecializationWithWorkersMoreThan20(ArrayList<Manager> managers) throws IOException {
        writeWithAppend("FileService\\managerOutput.txt", "Method #4\n");
        Collections.sort(managers,new RoleComparator());
        for(Manager manager: managers) {
            if(manager.getNumberOfWorkersUnderSupervision() > 20) {
                writeWithAppend("FileService\\managerOutput.txt",manager.toString()+"\n");
            }
        }
    }

}
