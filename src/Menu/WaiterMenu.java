package Menu;

import Employee.Waiter;
import FileManager.FileService;
import Service.WaiterService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaiterMenu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        WaiterService waiterService = new WaiterService();

        try {
            FileService.createFile("./FileService","waiterInput.txt");
            FileService.createFile("FileService","waiterOutput.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Waiter> waiters = new ArrayList<>();


        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("\nEnter command number");
            System.out.println("1. work with sample Waiters");
            System.out.println("2. create a new Waiter list");
            System.out.println("Please select these options only after waiters' list is stated");
            System.out.println("3. write names of waiters sorted by wage rate");
            System.out.println("4. write waiter with earliest hire date");
            System.out.println("5. write the sorted waiters' list by tips");
            System.out.println("6. write the reverse sorted female waiters' list by worked hours");
            System.out.println("7. Exit");

            System.out.println();

            int command = keyboard.nextInt();

            try {
                switch (command) {
                    case 1 -> {
                        FileService.write("./FileService\\waiterInput.txt","Anna,Hakobyan,20,f,1,23/11/2020,4000,40,6000,5\n");
                        FileService.writeWithAppend("./FileService\\waiterInput.txt","Tigran,Gevorgyan,24,m,3,12/10/2019,3500,34,4000,3\n");
                        FileService.writeWithAppend("./FileService\\waiterInput.txt","Meri,Saghatelyan,23,f,0,21/01/2021,3000,30,4500,4\n");
                        List<String> list = (FileService.read("FileService\\waiterInput.txt"));
                        for(String element:list) {
                            waiters.add(new Waiter(element));
                        }
                    }
                    case 2 -> {
                        System.out.println("Please provide information in the following format: ");
                        System.out.println("name,surname,age,gender,experience,hire date (dd/mm/yyyy), wage rate, worked hours, tips, number of served tables");
                        System.out.println("To exit, input -1");
                        keyboard.nextLine();
                        FileService.write("FileService\\waiterInput.txt",keyboard.nextLine()+"\n");
                        while(keyboard.hasNextLine()) {
                            String text = keyboard.nextLine();
                            if(text.equals("-1")) {
                                break;
                            }
                            FileService.writeWithAppend("FileService\\waiterInput.txt",text+"\n");
                        }
                        List<String> list = (FileService.read("FileService\\waiterInput.txt"));
                        for(String element:list) {
                            waiters.add(new Waiter(element));
                        }
                    }
                    case 3 -> waiterService.writeNamesSortedByWageRates(waiters);
                    case 4 -> waiterService.writeWaiterWithEarliestHireDate(waiters);
                    case 5 -> waiterService.sortWaitersByTips(waiters);
                    case 6 -> waiterService.sortFemaleWaitersByReversedWorkedHours(waiters);
                    case 7 -> {
                        isMenuActive = false;
                        System.out.println("Bye");
                    }
                    default -> System.out.println("Invalid command number");
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
