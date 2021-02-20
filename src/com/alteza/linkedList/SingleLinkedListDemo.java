package com.alteza.linkedList;

/**
 * 单向链表
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "路径", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

//        SingleLinkedList list = new SingleLinkedList();
//        list.add(heroNode1);
//        list.add(heroNode2);
//        list.add(heroNode3);
//        list.add(heroNode4);

        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode4);
        list.addByOrder(heroNode2);
        list.addByOrder(heroNode3);

        list.list();
    }

}

//定义一个SingleList 挂管理我们的英雄
class SingleLinkedList {

    //先初始化头节点 不存法国具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加方法
    // 思路：当不考虑编号顺序：找到链表的最后节点，将最后这个节点的next指向新的节点
    public void add(HeroNode node) {
        //因为head不能动 因此我们需要一个辅助变量
        HeroNode temp = head;
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //没找到，将temp后移
            temp = temp.next;
        }
        temp.next = node;
    }

    //显示链表
    public void list() {
        //判断聊表是否为空
        if (head.next == null) {
            System.out.println("聊表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //第二种方式，添加英雄，根据排名将英雄插入指定位置
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;//添加标识 默认是false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {//标号存在 不能添加
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag
        if (flag) {
            System.out.println("准备插入的已经存在，不能添加");
        } else {
            //插入
            node.next = temp.next;
            temp.next = node;
        }

    }

}

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    public HeroNode(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}