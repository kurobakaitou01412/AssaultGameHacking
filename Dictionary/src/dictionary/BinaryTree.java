/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author kuroba kaitou
 */
public class BinaryTree {
    
    BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(String vn, LinkedList en) {
        BinaryNode p = root;
        BinaryNode parent = null;
        while (p != null) {
            parent = p;
            if (p.key.compareToIgnoreCase(vn) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (root == null) {
            root = new BinaryNode(vn, en);
        } else {
            if (parent.key.compareToIgnoreCase(vn) > 0) {
                parent.left = new BinaryNode(vn, en);
            } else {
                parent.right = new BinaryNode(vn, en);
            }
        }
    }

    public LinkedList Search(BinaryNode p, String vn) {
        boolean Found = false;

        while (p != null && Found == false) {
            if (vn.equals(p.key)) {
                Found = true;
            } else {
                if (p.key.compareToIgnoreCase(vn) > 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }
        if (p == null) {
            return null;
        } else {
            return p.value;
        }
    }

    public LinkedList Search(String vn) {
        return Search(root, vn);
    }



    public void print() {
        System.out.println("root: " + root.key);
        System.out.println("right: " + root.right);
        System.out.println("left: " + root.left);
    }

    @Override
    public String toString() {
        return "BinaryTree{" + "root=" + root + '}';
    }

}
