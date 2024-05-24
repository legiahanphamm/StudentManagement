package data;

import java.util.Scanner;
import utilities.MyToys;

public class Shelf {

    private String color;
    private String label; //tủ hồ sơ SE, IA, GD, JP
    private int count = 0;

    public Shelf(String color, String label) {
        this.color = color;
        this.label = label;
    }

    //chứa cái gì
    private Student[] list = new Student[100];
    private Scanner sc = new Scanner(System.in);
    //tui có không gian chứa in4, tui sẽ giải quyết chuyện nhập xuất

    public void sortList() {
        int a, b;
        
        for (int i = 0; i < (count - 1); i++) {
            for (int j = i; j < count; j++) {
                a = Integer.parseInt(list[i].getId().substring(2, 7));
                b = Integer.parseInt(list[j].getId().substring(2, 7));
                if (a > b ) {
                    Student tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }

        System.out.println("After sorting");
        printList();
    }

    public void changeInfo() {
        int index = 0, choice;
        index = searchInfo();
        
        System.out.println("Which do you want to change?");
        System.out.printf("1. Student ID\t2. Name\t3. YOB\t4. GPA\nYour choice: ");
        choice = Integer.parseInt(sc.nextLine());
        
        while (choice < 1 || choice > 4) {
            System.out.print("Please input an integer from 1 to 4: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    System.out.printf("Please input again Student ID: ");
                    list[index].setId(sc.nextLine());
                    
                    System.out.println("After changing");
                    list[index].showProfile();
                    
                    break;
                }

                case 2: {
                    System.out.printf("Please input again Student's name: ");
                    list[index].setName(sc.nextLine());
                    
                    System.out.println("After changing");
                    list[index].showProfile();
                    break;
                }

                case 3: {
                    System.out.printf("Please input again Student's YOB: ");
                    list[index].setYob(Integer.parseInt(sc.nextLine()));
                    
                    System.out.println("After changing");
                    list[index].showProfile();
                    break;
                }
                
                case 4: {
                    System.out.printf("Please input again Student's GPA: ");
                    list[index].setGpa(Double.parseDouble(sc.nextLine()));
                    
                    System.out.println("After changing");
                    list[index].showProfile();
                    break;
                }
            }
        }
    }

    public int searchInfo() {
        int index = 0;
        String id;
        System.out.print("Student ID: ");
        id = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (id == list[i].getId()) {
                System.out.println("Found at (" + (i+1) + "/" + count);
                list[i].showProfile();
                index = i;
                break;
            } else {
                if ((i + 1) == count)
                    System.out.println("Not found.");
            }
        }
        return index;
    }

    public void removeStudents() {
        Scanner sc = new Scanner(System.in);

        String yn;
        int x, index;

        sortList();

        System.out.print("How many students do you want to delete? - ");
        x = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= x; i++) {
            if ((count) == 0) {
                System.out.println("Cannot delete anymore!");
                break;
            }
            System.out.println("Student " + i + "/" + x);

            index = searchInfo();

            try {
                System.out.printf("Please check student's information. Do you want to continue? (Y/N) - ");
                yn = sc.nextLine().toUpperCase();
            } catch (Exception e) {
                do {
                    System.out.println("Error. Please just input 'Y' or 'N'!");
                    yn = sc.nextLine().toUpperCase();
                } while (yn != "Y" && yn != "N");
            }

            if ("Y".equals(yn)) {
                for (int k = index; k < (count - 1); k++) {
                    list[k] = list[k + 1];
                }
                System.out.println("Deleted successfully.");
                count--;
                System.out.println("New list");
                printList();
            } else {
                System.out.println("Cancelled successfully.");
                break;
            }
        }
    }

    public void inputStudents() {
        Scanner sc = new Scanner(System.in);

        String name, id;
        int yob, x;
        double gpa;

        System.out.print("How many students do you want to add? - ");
        x = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= x; i++) {
            if ((count + 1) == list.length) {
                System.out.println("Cannot add anymore!");
                break;
            }

            System.out.println("INPUT STUDENT'S INFORMATION (" + (count + 1) + "/" + list.length + ")");
            name = MyToys.getString("Name: ", "ERROR! Please input again.");
            id = MyToys.getID("Student ID (SExxxxxx): ", "ERROR! Please input again.", "^[SE|se]\\d{6}$");
            yob = MyToys.getAnInteger(2000, 2006, "YOB: ", "ERROR! Please input again.");
            gpa = MyToys.getADouble("GPA: ", "ERROR! Please input again.");
            System.out.println("-----------------------------------------");

            list[count] = new Student(id, name, yob, gpa);
            count++;

            System.out.println("Added successfully.");
        }
    }

    public void printList() {
        for (int i = 0; i < count; i++) {
            list[i].showProfile();
            System.out.println("");
        }
    }
}
