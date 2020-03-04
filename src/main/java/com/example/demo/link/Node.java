package com.example.demo.link;

/**
 * @author hongjian.chen
 * @date 2020/3/4 17:01
 */
public class Node {
    private String data; // 用于保存数据
    private Node next; // 用于保存下一个节点

    public Node(String data) {  // 每一个Node类对象都必须保存有响应的数据
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public String getData() {
        return this.data;
    }

    // 实现节点的添加:
    // 第一次调用（LinkTest）：this代表Link.root
    // 第二次调用（Node）：this代表Link.root.next
    // 第三次调用（Node）：this代表Link.root.next.next
    public void addNode(Node newNode) {
        if (this.next == null) {   // 保存新节点
            this.next = newNode;
        } else {                 // 当前节点后面还有节点
            this.next.addNode(newNode);  // 当前节点的下一个节点继续保存,这里采用的是递归添加节点
        }
    }

    // 第一次调用（LinkTest）：this代表Link.root
    // 第二次调用（Node）：this代表Link.root.next
    // 第三次调用（Node）：this代表Link.root.next.next
    public void printNode() {
        System.out.println("data:" + data);// 输出当前数据
        if (this.next != null) {      // 如果还有下一个节点，输出下一节点
            this.next.printNode();   // 递归打印节点，注意这里的this.next中的this指代
        }
    }
}
