package com.example.demo.link;

/**
 * @author hongjian.chen
 * @date 2020/3/4 17:04
 */
public class LinkTest {
    private Node root; //新建根节点

    public void addTest(String data) {
        Node newNode = new Node(data);  //链表中新增节点类对象
        if (root == null) {         // 如果链表还没有任何节点,就添加第一个节点作为根节点
            root = newNode;
            System.out.println("root:" + root);
        } else {
            System.out.println("new:" + newNode);
            root.addNode(newNode);  //从根节点新链接一个节点
        }
    }

    //输出当前节点数据
    public void print() {
        if (root != null) {
            root.printNode();
        }
    }

    public static void main(String[] args) {
        LinkTest linkTest = new LinkTest();
        linkTest.addTest("hello");   //增加节点
        linkTest.addTest("world");
        linkTest.addTest("www");
        linkTest.print();     //打印数据
    }
}
