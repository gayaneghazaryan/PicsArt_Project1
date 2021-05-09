package Menu;

import Employee.Manager;
import FileManager.FileService;
import Service.ManagerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMenu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ManagerService managerService = new ManagerService();

        try {
            FileService.createFile("./FileService","managerInput.txt");
            FileService.createFile("FileService","managerOutput.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Manager> managers = new ArrayList<>();


        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("\nEnter command number");
            System.out.println("1. work with sample Managers");
            System.out.println("2. create a new Manager list");
            System.out.println("Please select these options only after chefs' list is stated.");
            System.out.println("3. write surnames of managers sorted by age who are older than 25");
            System.out.println("4. write the info of the manager with the lowest salary");
            System.out.println("5. write the reverse sorted managers' list by the number of workers under supervision");
            System.out.println("6. write the sorted managers' list by specialization who have more than 20 workers under supervision");
            System.out.println("7. Exit");

            System.out.println();
            int command = keyboard.nextInt();

            try {
                switch (command) {
                    case 1 -> {
                        FileService.write("FileService\\managerInput.txt","Gayane,Galoyan,38,f,10,12/05/2017,400000,5000,20,General,35\n");
                        FileService.writeWithAppend("FileService\\managerInput.txt","Sargis,Mehrabyan,25,m,1,31/06/2019,200000,3500,10,Bar,5\n");
                        FileService.writeWithAppend("FileService\\managerInput.txt","Anna,Hovsepyan,30,f,3,01/03/2018,320000,4000,15,Kitchen,22\n");
                        List<String> list = (FileService.read("FileService\\managerInput.txt"));
                        for(String element:list) {
                            managers.add(new Manager(element));
                        }
                    }
                    case 2 -> {
                        System.out.println("Please provide information in the following format: ");
                        System.out.println("name,surname,age,gender,experience,hire Date (dd/mm/yyyy), salary, overtime pay, overtime hours, specialization,number of workers under supervision");
                        System.out.println("To exit, input -1");
                        keyboard.nextLine();
                        FileService.write("FileService\\managerInput.txt",keyboard.nextLine()+"\n");
                        while(keyboard.hasNextLine()){
                            String text = keyboard.nextLine();
                            if(text.equals("-1")) {
                                break;
                            }
                            FileService.writeWithAppend("FileService\\managerInput.txt",text+"\n");
                        }
                        List<String> list = (FileService.read("FileService\\managerInput.txt"));
                        for(String element:list) {
                            managers.add(new Manager(element));
                        }

                    }
                    case 3 -> managerService.writeSurnamesSortedByAgeWhoAreOlderThan25(managers);
                    case 4 -> managerService.writeManagerWithLowestSalary(managers);
                    case 5 -> managerService.sortManagersByReversedNumbersOfWorkersUnderSupervision(managers);
                    case 6 -> managerService.sortManagersBySpecializationWithWorkersMoreThan20(managers);
                    case 7 -> {
                        isMenuActive = false;
                        System.out.println("Bye");
                    }
                    default -> System.out.println("Invalid command number");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
