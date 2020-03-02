/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author moham
 */
public class Stack<N extends Comparable<N>> {

    class Node<N extends Comparable<N>> {

        N data;
        int priority;
        Node<N> next;

        Node(N data, int a) {
            next = null;
            this.data = data;
            priority = a;
        }
    }
    Node<N> Head;
    int size = 0;

    public int getSize() {
        return size;
    }
    // we need push , pop , Top

    public N Top() {
        return Head.data;
    }

    public boolean empty() {
        return !(size > 0);
    }

    public boolean push(N data, int a) {
        Node< N> node = new Node<>(data, a);
        if (node != null) {
            size++;
            if (Head == null) {

                Head = node;

            } else {
                node.next = Head;
                Head = node;
            }
            return true;
        }
        return false;
    }

    public N Npop() {
        N da = null;
        if (Head != null) {
            size--;
            da = Head.data;
            Head = Head.next;
        }
        return da;
    }

    public Node pop() { 
        Node<N> da = null;
        if (Head != null) {
            da = Head;
//            System.out.println(" sizzzzzzzzzzzzeeeeeeeeeeeeee "+size);
            size--;
            Head = Head.next;
            
            da.next = null;
        }
        return da;
    }

    public void InsertFromQueue(Queue<N> Q) {
//        return ;
        if (Q.getSize() > 0) {
            
//            System.out.println("Q.size ama nshof  "+Q.getSize());
            
//            System.out.println("reached 1");
            Queue.Node temp = Q.pop();
//            System.out.println("reached 2");
//                temp = Q.Head;                    
//            System.out.println("STAAACK    INSERTFROM Q   "+Q.getSize()+"    TEMP    NULL   "+(temp==null)+"   stack size   "+size+"    temp.data    "+temp.data);
            push((N) temp.data, temp.priority);
//            if(temp!=null)
//                push((N) temp.data, temp.priority);
//            else
//                System.out.println("STAAACK    INSERTFROM Q   "+Q.getSize()+"    TEMP    NULL   "+(temp==null));
        }
    }

    public void print() {
        if (Head != null) {
            Node<N> temp = Head;
            int i = 1;
            while (temp != null) {
                System.out.println("Data number " + (i++) + "  is  " + temp.data + "   with priority    " + temp.priority);
                temp = temp.next;
            }
        }
    }

}
