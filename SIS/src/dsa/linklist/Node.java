/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa.linklist;

/**
 *
 * @author fawad
 */
public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}