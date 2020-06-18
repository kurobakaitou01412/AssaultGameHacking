/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author kuroba kaitou
 */
public class Dictionary {
    
    public static void main(String[] args) {
        File fileName = new File("EN_dictionary.txt");
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            BinaryTree EN_Tree = new BinaryTree();
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("\uFEFF"))
                    line = line.substring(1);
                String vn,en1;
                LinkedList<String> en = new LinkedList<>();
                StringTokenizer stk = new StringTokenizer(line, ":");
                vn = stk.nextToken().trim();
                String temp = stk.nextToken().trim();
                StringTokenizer stkk = new StringTokenizer(temp, ",");
                while (stkk.hasMoreElements())
                    en.add(stkk.nextToken());
                EN_Tree.insert(vn, en);
            }
            System.out.println(EN_Tree.Search("cùng"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
