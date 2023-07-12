package dsa.linklist;

import common.Student;
import model.Message;
import model.MessageType;

public class LinkedList<T> {

    public Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T value) {
        Node<T> n = new Node<>(value);
        if (isEmpty()) {
            head = n;
            size++;
        } else {
            n.next = head;
            head = n;
            size++;
        }
    }

    public void add(T value) {
        Node<T> n = new Node<>(value);
        if (isEmpty()) {
            head = n;
            size++;
        } else {
            Node<T> p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
            size++;
        }
    }

    public void delete(T key) {
        Node<T> temp = head;
        Node<T> prev = null;

        if (temp != null && temp.data.equals(key)) {
            head = temp.next; // Change the head node
            size--;
            return;
        }

        while (temp != null && !temp.data.equals(key)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key is not found.");
            return;
        }

        prev.next = temp.next;
        size--;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is Empty.");
        } else {
            Node<T> n = head;
            while (n != null) {
                System.out.print(n.data + "\t");
                n = n.next;
            }
            System.out.println();
        }
    }

    public Student find(String key) {
        Node<Student> temp = (Node<Student>) head;
        while (temp != null) {
            if (temp.data.getRegNo().equals(key)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public String getErrorMessages() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            System.out.println("List is Empty.");
        } else {
            Node<Message> n = (Node<Message>) head;
            while (n != null) {
                if (sb.length() > 0) {
                    sb.append(",\n");
                }
                if (n.getData().Type == MessageType.Error || n.getData().Type == MessageType.Exception) {
                    sb.append(n.data.Message);
                }
                n = n.next;
            }
        }

        return sb.toString();
    }
    public String getInfoMessages() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            System.out.println("List is Empty.");
        } else {
            Node<Message> n = (Node<Message>) head;
            while (n != null) {
                if (sb.length() > 0) {
                    sb.append(",\n");
                }
                if (n.getData().Type == MessageType.Information ) {
                    sb.append(n.data.Message);
                }
                n = n.next;
            }
        }

        return sb.toString();
    }

    public boolean hasError() {
    Node<Message> n = (Node<Message>) head;
    while (n != null) {
        if (n.getData().Type == MessageType.Error || n.getData().Type == MessageType.Exception) {
            return true;
        }
        n = n.next;
    }
    return false;
}


}
