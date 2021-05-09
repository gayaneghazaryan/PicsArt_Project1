package Menu;

import Employee.Bartender;
import FileManager.FileService;
import Service.BartenderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BartenderMenu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BartenderService bartenderService = new BartenderService();

        try{
            FileService.createFile("FileService","bartenderInput.txt");
            FileService.createFile("FileService","bartenderOutput.txt");
        }catch(IOException e) {
            e.printStackTrace();
        }


        ArrayList<Bartender> bartenders = new ArrayList<>();


        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("\nEnter command number");
            System.out.println("1. work with sample Bartenders");
            System.out.println("2. create a new Bartender list");
            System.out.println("Please select these options only after bartenders' list is stated");
            System.out.println("3. write full names of bartenders sorted by Hire Date");
            System.out.println("4. write the info of the oldest bartender");
            System.out.println("5. write the reverse sorted bartenders' list by the number of served clients");
            System.out.println("6. write the sorted chefs' list by signature drink who serve alcohol");
            System.out.println("7. Exit");

            System.out.println();
            int command = keyboard.nextInt();

            try {
                switch (command) {
                    case 1 ->{
                        FileService.write("FileService\\bartenderInput.txt","Hayk,Ghazaryan,25,m,5,18/01/2019,5500,55,35,yes,Cosmopolitan\n");
                        FileService.writeWithAppend("FileService\\bartenderInput.txt","Anna,Stepanyan,28,f,1,12/09/2018,3000,40,25,no,Virgin Mary\n");
                        FileService.writeWithAppend("FileService\\bartenderInput.txt","Arman,Hakobyan,20,m,3,25/06/2020,4000,45,30,yes,Tequila Sunrise\n");
                        List<String> list = (FileService.read("FileService\\bartenderInput.txt"));
                        for(String element:list) {
                            bartenders.add(new Bartender(element));
                        }
                    }
                    case 2 ->{
                        System.out.println("Please provide information in the following format: ");
                        System.out.println("name,surname,age,gender,experience,hire date (dd/mm/yyyy), wage rate, worked hours, number of ServedClients, servedAlcohol, signature drink");
                        System.out.println("To exit, input -1");
                        keyboard.nextLine();
                        FileService.write("FileService\\bartenderInput.txt",keyboard.nextLine()+"\n");
                        while(keyboard.hasNextLine()) {
                            String text = keyboard.nextLine();
                            if(text.equals("-1")) {
                                break;
                            }
                            FileService.writeWithAppend("FileService\\bartenderInput.txt",text+"\n");
                        }
                        List<String> list = (FileService.read("FileService\\bartenderInput.txt"));
                        for(String element:list) {
                            bartenders.add(new Bartender(element));
                        }

                    }
                    case 3 -> bartenderService.writeFullNamesSortedByHireDate(bartenders);
                    case 4 -> bartenderService.writeOldestBartender(bartenders);
                    case 5 -> bartenderService.sortBartenderByReversedNumberOfServedClients(bartenders);
                    case 6 -> bartenderService.sortBartendersServingAlcoholBySignatureDrink(bartenders);
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
