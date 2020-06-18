/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author kuroba kaitou
 */
public class BinaryTree {

    public BinaryNode root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public void insertNode(SoftwareInfo software) {
        BinaryNode p = root;
        BinaryNode parent = null;
        if (searchNode(software.name) != null) {
            System.out.println("Error, this software is already have");
            return;
        }
            
        while (p != null) {
            parent = p;
            if (p.info.name.compareToIgnoreCase(software.name) > 0)
                p = p.left;
            else 
                p = p.right;
        }
        if (root == null) {
            root = new BinaryNode(software);
        } else {
            if (parent.info.name.compareToIgnoreCase(software.name) > 0)
                parent.left = new BinaryNode(software);
            else
                parent.right = new BinaryNode(software);
        }
    }
    
    public SoftwareInfo searchNode(BinaryNode p, String name) {
        boolean found = false;
        while (p != null && found == false) {
            if (name.equals(p.info.name)) {
                found = true;
            } else {
                if (p.info.name.compareToIgnoreCase(name) > 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }
        if (p == null) {
            return null;
        } else {
            return p.info;
        }
    }
    
    public SoftwareInfo searchNode(String name) {
        return searchNode(root, name);
    }
    
    public void inOrder(BinaryNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        visit(node);
        inOrder(node.right); 
    }
    public void visit(BinaryNode node) {
        if (node != null)
            System.out.println(node.info);
    }
    
    public void printTree() {
        inOrder(root);
    }
    
    public void buySoftware() {
        int validation;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input name");
        String name = sc.nextLine();
        if (searchNode(name) != null) {
            while(true) {
                validation = myLibrary.MyLibrary.getInt("Input number you need to buy");
                SoftwareInfo software = searchNode(name);
                if (validation <= software.quantity) {
                    software.quantity -= validation;
                    System.out.println("Buy successful");
                    return;
                }
                else if (software.quantity == 0) {
                    System.out.println("Error, this software is out of stock");
                    return;
                }
                else
                    System.out.println("Error, you can not buy more than we have, we only have" + software.quantity);
            }
        }
        else
            System.out.println("Error, software can not found");
    }
}
