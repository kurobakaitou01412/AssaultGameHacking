/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author kuroba kaitou
 */
public class BinaryNode {
    public SoftwareInfo info;
    public BinaryNode left, right;

    public BinaryNode() {
    }

    public BinaryNode(SoftwareInfo info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public SoftwareInfo getRoot() {
        return info;
    }

    public void setRoot(SoftwareInfo info) {
        this.info = info;
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
    
}
