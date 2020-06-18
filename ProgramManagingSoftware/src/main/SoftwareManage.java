/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import data.*;
import data.BinaryTree;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author kuroba kaitou
 */
public class SoftwareManage {
    public static void main(String[] args) {
        File fileName = new File("Software.txt");
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        try {
            SoftwareInfo software = null;
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                while (stk.hasMoreElements()) {
                    String name = stk.nextToken();
                    float version = Float.parseFloat(stk.nextToken());
                    int quantity = Integer.parseInt(stk.nextToken());
                    int price = Integer.parseInt(stk.nextToken());
                    software = new SoftwareInfo(name, version, quantity, price);
                }
                tree.insertNode(software);
            }
            br.close();
            fr.close();
//            tree.printTree();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> menu= new ArrayList<>();
        menu.add("Software manage programe");
        menu.add("1. Show software");
        menu.add("2. Buy software by name");
        menu.add("3. Add new software");
        menu.add("4. Exit");
        int choice = 0;
        do {
            for (String string : menu)
                System.out.println(string);
            choice = myLibrary.MyLibrary.getInt();
            switch(choice) {
                case 1:
                    tree.printTree();
                    break;
                case 2:
                    tree.buySoftware();
                    break;
                case 3:
                    System.out.println("Input name");
                    String name = sc.nextLine();
                    if (tree.searchNode(name) != null) {
                        System.out.println("Error this software is already have");
                        break;
                    }
                    float version = myLibrary.MyLibrary.getFloat("Input version");
                    int quantity = myLibrary.MyLibrary.getInt("Input quantity");
                    int price = myLibrary.MyLibrary.getInt("Input price");
                    SoftwareInfo software = new SoftwareInfo(name, version, quantity, price);
                    System.out.println("Add successful");
                    tree.insertNode(software);
                    break;
                case 4:
                    saveFile(fileName, tree);
                    break;
            }
        } while (choice != 4);
    }
    public static void saveFile(File fileName, BinaryTree tree){
        try {
            SoftwareInfo software = null;
            FileWriter fw = new FileWriter(fileName, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            inOrder(tree.root, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inOrder(BinaryNode node, File fileName) {
        if (node == null)
            return;
        inOrder(node.left, fileName);
        visit(node, fileName);
        inOrder(node.right, fileName);
    }
    public static void visit(BinaryNode node, File fileName) {
        if (node != null)
            if (node.info.getQuantity() != 0) {
                try {
                SoftwareInfo software = null;
                FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.print(node.info.getName() + "," + node.info.getVersion() + "," + node.info.getQuantity() + "," + node.info.getPrice() + "\n");
                pw.close();
                bw.close();
                fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }  
    }
}
