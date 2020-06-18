/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myLibrary;

import java.util.Scanner;

/**
 *
 * @author kuroba kaitou
 */
public class MyLibrary {
    static Scanner sc = new Scanner(System.in);
    
    public static int getInt() {
        System.out.println("Please input choice");
        
        int choice;
        while(true) {
            String result = sc.nextLine();
            try {
                choice = Integer.parseInt(result);
                if (choice >= 1 && choice <= 4)
                    return choice;
                else
                    System.out.println("Choice must be in range 1 - 4");
            } catch (Exception e) {
                System.out.println("Choice must be digits only");
            }
        }
    }
    
    public static int getInt(String msg) {
        System.out.println(msg);
        int price;
        while(true) {
            String result = sc.nextLine();
            try {
                price = Integer.parseInt(result);
                if (price >0)
                    return price;
                else
                    System.out.println("Choice must be more than 0");
            } catch (Exception e) {
                System.out.println("Choice must be digits only");
            }
        }
    }
    
    public static float getFloat(String msg) {
        System.out.println(msg);
        float result;
        while(true) {
            String input = sc.nextLine();
            try {
                result = Float.parseFloat(input);
                if (result > 0)
                    return result;
                else
                    System.out.println("Input must be more than zero");
            } catch (Exception e) {
                System.out.println("Input must be digits only");
            }
        }
    }
    
}
