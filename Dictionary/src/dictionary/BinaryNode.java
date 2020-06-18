/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.LinkedList;

/**
 *
 * @author kuroba kaitou
 */
public class BinaryNode {
    String key;
    LinkedList<String> value;
    BinaryNode left = null;
    BinaryNode right = null;

    public BinaryNode() {
        
    }

    public BinaryNode(String key, LinkedList<String> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LinkedList<String> getValue() {
        return value;
    }

    public void setValue(LinkedList<String> value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    

    @Override
    public String toString() {
        return String.format("\n%s%s%s%s", key, value, left, right);
    }
    
}
