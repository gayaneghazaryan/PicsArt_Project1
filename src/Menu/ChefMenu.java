package Menu;

import Employee.Chef;
import FileManager.FileService;
import Service.ChefService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChefMenu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ChefService chefService = new ChefService();

        try {
            FileService.createFile("./FileService","chefInput.txt");
            FileService.createFile("FileService","chefOutput.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Chef> chefs = new ArrayList<>();

        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("\nEnter command number");
            System.out.println("1. work with sample Chefs");
            System.out.println("2. create a new Chef and add to a list");
            System.out.println("Please select these options only after chefs' list is stated");
            System.out.println("3. write full names of chefs sorted by specialization");
            System.out.println("4. write the info of the most experienced chef");
            System.out.println("5. write the sorted chefs' list by the number of Michelin stars");
            System.out.println("6. write the sorted female chefs' list by cuisine");
            System.out.println("7. Exit");

            System.out.println();
            int command = keyboard.nextInt();

            try {
                switch (command) {
                    case 1 -> {
                        FileService.write("./FileService\\chefInput.txt","Anahit,Chukhajyan,25,f,3,21/05/2019,100000,5000,20,0,Fish,Chinese\n");
                        FileService.writeWithAppend("./FileService\\chefInput.txt","Lilit,Sargsyan,35,f,10,14/03/2017,200000,3500,10,2,Executive,Italian\n");
                        FileService.writeWithAppend("./FileService\\chefInput.txt","Vardan,Ghazaryan,30,m,5,21/10/2020,320000,4000,15,1,Pastry,French\n");
                        List<String> list = (FileService.read("FileService\\chefInput.txt"));
                        for(String element:list) {
                            chefs.add(new Chef(element));
                        }
                    }
                    case 2 ->{
                        System.out.println("Please provide information in the following format: ");
                        System.out.println("name,surname,age,gender,experience,hire date (dd/mm/yyyy), salary, overtime pay, overtime hours, stars of Michelin,specialization,cuisine");
                        System.out.println("To exit, input -1");
                        keyboard.nextLine();
                        FileService.write("FileService\\chefInput.txt",keyboard.nextLine());
                        while(keyboard.hasNextLine()) {
                            String text = keyboard.nextLine();
                            if(text.equals("-1")) {
                                break;
                            }
                            FileService.writeWithAppend("FileService\\chefInput.txt",text);
                        }
                        List<String> list = (FileService.read("FileService\\chefInput.txt"));
                        for(String element:list) {
                            chefs.add(new Chef(element));
                        }

                    }
                    case 3 -> chefService.writeFullNamesSortedBySpecialization(chefs);
                    case 4 -> chefService.writeMostExperiencedChef(chefs);
                    case 5 -> chefService.sortChefsByMichelinStars(chefs);
                    case 6 -> chefService.sortFemaleChefsByCuisine(chefs);
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
