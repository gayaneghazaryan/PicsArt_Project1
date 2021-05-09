import Employee.Bartender;
import Employee.Manager;
import Menu.BartenderMenu;
import Menu.ChefMenu;
import Menu.ManagerMenu;
import Menu.WaiterMenu;

import java.util.Scanner;

public class GeneralMenu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("\nEnter command number");
            System.out.println("1. work with Chefs");
            System.out.println("2. work with Managers");
            System.out.println("3. work with Bartenders");
            System.out.println("4. work with Waiters");
            System.out.println("5. Exit");

            System.out.println();
            int command = keyboard.nextInt();

            switch (command) {
                case 1 -> ChefMenu.main(null);
                case 2 -> ManagerMenu.main(null);
                case 3 -> BartenderMenu.main(null);
                case 4 -> WaiterMenu.main(null);
                case 5 -> {
                    isMenuActive = false;
                    System.out.println("Bye");
                }
                default -> System.out.println("Invalid command number");
            }

        }
    }
}
