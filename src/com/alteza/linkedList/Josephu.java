package com.alteza.linkedList;

//约瑟夫问题 环形链表
public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.add(5);
        list.show();

        list.count(1,2,5);
    }

}

//创建环形里列表
class CircleSingleLinkedList {
    //创建first
    private Boy first = new Boy(-1);

    public void add(int num) {
        if (num < 1) {
            System.out.println("数值错误");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("null");
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩编号%d\n", cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * @param start 从第几个小孩开始
     * @param count 表示数几下
     * @param num   最初小孩数量
     */
    public void count(int start, int count, int num) {
        if (first == null || start < 1 || start > num) {
            System.out.println("参数错误");
            return;
        }
        Boy helper = first;
        //让helper指向最后一个
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
//
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩出去%d\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("小孩出去%d\n", helper.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
