package studentmanagement;

import data.Student;
import data.Shelf;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Shelf se = new Shelf("RED", "Software Engineering");
        Shelf ai = new Shelf("YELLOW", "Artificial Intelligence");
        int op = 0, lb = 0;

        System.out.println("WELCOME TO STUDENT MANAGEMENT APPLICATION!");
        while (op != 7) {
            printMenu();
            System.out.printf("Please choose an option (1..7)\nYour choice: ");
            op = Integer.parseInt(sc.nextLine());

            while (op > 7 || op < 1) {
                System.out.printf("Please, input an integer from 1 to 7!\nYour choice: ");
                op = Integer.parseInt(sc.nextLine());
            }

            switch (op) {
                case 1: {
                    lb = chooseLabel(sc);

                    if (lb == 1) {
                        se.inputStudents();
                    } else {
                        ai.inputStudents();
                    }
                    break;
                }

                case 2: {
                    lb = chooseLabel(sc);
                    
                    if (lb == 1) {
                        se.removeStudents();
                    } else {
                        ai.removeStudents();
                    }
                    break;
                }
                
                case 3: {
                    lb = chooseLabel(sc);
                    
                    if (lb == 1) {
                        se.changeInfo();
                    } else {
                        ai.changeInfo();
                    }
                    break;
                }
                
                case 4: {
                    lb = chooseLabel(sc);
                    
                    if (lb == 1) {
                        se.searchInfo();
                    } else {
                        ai.searchInfo();
                    }
                    break;
                }

                case 5: {
                    lb = chooseLabel(sc);
                    
                    if (lb == 1) {
                        se.sortList();
                    } else {
                        ai.sortList();
                    }
                    break;
                }

                case 6: {
                    lb = chooseLabel(sc);
                    
                    if (lb == 1) {
                        se.printList();
                    } else {
                        ai.printList();
                    }
                    break;
                }

                case 7: {                    
                    System.out.println("Thank you. See you again!");
                    break;
                }
            }
        }
    }

    public static int chooseLabel(Scanner sc) {
        int lb = 0;

        System.out.printf("(1) SE\n(2) AI\nYour choice: ");
        lb = Integer.parseInt(sc.nextLine());

        while (lb < 1 || lb > 2) {
            System.out.printf("Please, input 1 or 2\n(1) SE - (2) AI\nYour choice: ");
            lb = Integer.parseInt(sc.nextLine());
        }
        return lb;
    }

    public static void printMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("1. Add student(s).");
        System.out.println("2. Delete student(s).");
        System.out.println("3. Change information.");
        System.out.println("4. Search information.");
        System.out.println("5. Sort.");
        System.out.println("6. Show student list.");
        System.out.println("7. Quit.");
        System.out.println("-----------------------------------------");
    }
}
