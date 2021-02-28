package com.alteza.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

    }

}

class BinaryTree {
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //前序
    public void preOrder() {
        System.out.println(this);//父节点
        //递归 左
        if (this.left != null) {
            this.left.preOrder();
        }
        //右边
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        //父
        System.out.println(this);
        //递归 右边
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序
    public void postOrder() {
        if (this.left != null) {
            this.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}