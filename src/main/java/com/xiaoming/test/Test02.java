package com.xiaoming.test;

/**
 * @Author:zjb
 * @Date:2020/1/31
 * @Version 1.0
 */
public class Test02 {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyNode node1 = new MyNode(1, "小明");
        MyNode node2 = new MyNode(3, "小亮");
        MyNode node3 = new MyNode(5, "小王");
        MyNode node4 = new MyNode(7, "小黑");

        myLinkedList.add(node1);
        myLinkedList.add(node2);
        myLinkedList.add(node3);
        myLinkedList.add(node4);

//        myLinkedList.del(3);
//
//        myLinkedList.upd(new MyNode(5, "猪还笨"));
//
//        myLinkedList.addOrderById(new MyNode(6, "夕阳西下"));
//
//        myLinkedList.list();
//
//        System.out.println("链表长度：" + myLinkedList.getLength());

        MyLinkedList myLinkedList2 = myLinkedList.reverse();
        myLinkedList2.list();
    }

}

class MyLinkedList{
    MyNode head = new MyNode(0);

    // 添加
    public void add(MyNode myNode){
        MyNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = myNode;
    }

    // 有序添加
    public void addOrderById(MyNode myNode){
        MyNode temp = head;
        while(temp.next != null){
            if(temp.next.id > myNode.id){
                myNode.next = temp.next;
                temp.next = myNode;
                break;
            }else if(temp.next.id == myNode.id){
                System.out.println("节点已存在");
                break;
            }
            temp = temp.next;
        }
    }

    // 删除
    public void del(int id){
        MyNode temp = head;
        while(temp.next != null){
            if(temp.next.id == id){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("不存在要删除的节点");
    }

    // 修改
    public void upd(MyNode myNode){
        MyNode temp = head;
        while(temp.next != null){
            if(temp.next.id == myNode.id){
                temp.next.name = myNode.name;
                return;
            }
            temp = temp.next;
        }
        System.out.println("不存在要修改的节点");
    }

    // 查看
    public void list(){
        MyNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp);
        }
    }

    // 获取链表长度
    public int getLength(){
        MyNode temp = head;
        int length = 0;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }
        return length;
    }

    // 反转链表
    public MyLinkedList reverse(){
        MyNode temp = head.next;
        MyLinkedList myLinkedList2 = new MyLinkedList();
        if(head.next == null || head.next.next == null){
            return this;
        }
        MyNode next = null;
        while(temp != null){
            next = temp.next;
            temp.next = myLinkedList2.head.next;
            myLinkedList2.head.next = temp;
            temp = next;
        }
        return myLinkedList2;
    }
}

class MyNode{
    int id;
    String name;
    MyNode next;

    public MyNode(int id) {
        this.id = id;
    }

    public MyNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
