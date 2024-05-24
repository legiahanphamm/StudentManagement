package utilities;

import java.util.Scanner;

public class MyToys {

    public static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String input, String error) {
        int a = 0;
        while (true) {
            try {
                System.out.println(input);
                a = Integer.parseInt(sc.nextLine());
                return a;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static int getAnInteger(int min, int max, String input, String error) {
        int a = 0, tmp = 0;

        if (min > max) {
            tmp = min;
            min = max;
            max = tmp;
        }
        while (true) {
            try {
                System.out.println(input);
                a = Integer.parseInt(sc.nextLine());

                if (a > max || a < min) {
                    throw new Exception();
                }

                return a;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static double getADouble(String input, String error) {
        double a = 0;
        while (true) {
            try {
                System.out.println(input);
                a = Double.parseDouble(sc.nextLine());
                return a;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static double getADouble(double min, double max, String input, String error) {
        double a = 0, tmp = 0;

        if (min > max) {
            tmp = min;
            min = max;
            max = tmp;
        }
        while (true) {
            try {
                System.out.println(input);
                a = Double.parseDouble(sc.nextLine());

                if (a > max || a < min) {
                    throw new Exception();
                }

                return a;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
    
    public static String getString(String input, String error) {
        String str;        
        while (true) {
            System.out.print(input);
            str = sc.nextLine().trim();            
            if (str.length() == 0 || str.isEmpty())
                System.out.println(error);
            else 
                return str;
        }
    }
    
    public static String getID(String input, String error, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(input);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(error);
            else
                return id;            
        }
    }
}
