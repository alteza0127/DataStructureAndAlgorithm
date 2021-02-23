package com.alteza.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "路径", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList list = new DoubleLinkedList();
        list.add(heroNode1);
        list.add(heroNode2);
        list.add(heroNode3);
        list.add(heroNode4);
        list.list();

//        HeroNode2 heroNode5 = new HeroNode2(2, "恭顺", "你好啊");
//        list.addByNo(heroNode5);
//        list.delete(2);
//        list.list();

    }

}

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //根据编号添加
    public void addByNo(HeroNode2 node) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                flag = true;
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("存在");
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
            temp.next.pre = temp;
        }
    }

    //显示链表
    public void list() {
        //判断聊表是否为空
        if (head.next == null) {
            System.out.println("聊表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加方法
    // 思路：当不考虑编号顺序：找到链表的最后节点，将最后这个节点的next指向新的节点
    public void add(HeroNode2 node) {
        //因为head不能动 因此我们需要一个辅助变量
        HeroNode2 temp = head;
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //没找到，将temp后移
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //修改
    public void update(HeroNode2 node) {
        //判断聊表是否为空
        if (head.next == null) {
            System.out.println("聊表为空");
            return;
        }
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//已经遍历完
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.println("没有找到");
        }
    }

    //删除
    public void delete(int no) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.pre.next = temp.next.next;
            //判断是否为最后一个
            if (temp.next.next != null) {
                temp.next.next.pre = temp.next.pre;
            }
        } else {
            System.out.println("没有找到");
        }

    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;

    public HeroNode2(int hNo, String hName, String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
