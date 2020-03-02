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
public class LinkedListCircular<N extends Comparable<N>> {

    class Node<N extends Comparable<N>> {

        N data;
        int priority;
        Node<N> previous;
        Node<N> next;

        Node(N data, int a) {
            this.data = data;
            priority = a;
        }
    }
    Node<N> Head;
    int size = 0;

    public int getSize() {
        return size;
    }

    public Node pop_back() {
        Node<N> data = null;
        if (Head != null) {
            if(size==1){
                data = Head;
                Head.previous = Head.next = null;
                Head  = null;
            }else{
                data = Head.previous;
            Head.previous.previous.next = Head;
            Head.previous = Head.previous.previous;
            
            }
            size--;
        }
        return data;
    }

    public boolean push_sorted(N data, int priority) {
        Node<N> node = new Node<>(data, priority);
        int maxP = get_max_priority();
        if (node != null) {
            size++;
            if (Head == null) {
                Head = node;
                Head.next = Head;
                Head.previous = Head;
            } else if (size == 1) {
//                System.out.println("DATAA " + data);
                boolean F = false;
                if (Head.priority < priority) {
                } else if (Head.priority > priority) {
                    F = true;

                } else if (Head.data.compareTo(data) < 0) {
                    F = true;
                } else {

                }
                if (F) {
                    Head.previous = Head.next = node;
                    node.next = node.previous = Head;
                    Head = node;
                } else {
                    Head.previous = Head.next = node;
                    node.next = node.previous = Head;
                }
            } else {
//                        System.out.println("wwwwwwwwwwwwwwwwwwwww");
                Node<N> temp = Head;
                boolean F = false;
                do {
                    if (temp.priority > priority) {

//                    System.out.println("TEMP  "+temp.priority +"   pri   "+priority);
                        node.next = temp;
                        temp.previous.next = node;
                        node.previous = temp.previous;
                        temp.previous = node;
                        if (temp == Head) {
                            Head = node;
                        }
                        //asdasasdasd
                        F = true;
                        break;
                    } else if (temp.priority == priority) {
                        while (temp.priority == priority && data.compareTo(temp.data) < 0) {
//                        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqq");
                            temp = temp.next;
                        }
                        node.next = temp;
                        temp.previous.next = node;
                        node.previous = temp.previous;
                        temp.previous = node;

                        F = true;
                        break;
                    }
                    temp = temp.next;
                } while (temp != Head);
                if (F == false) {
                    node.next = Head;
                    Head.previous.next = node;
                    node.previous = Head.previous;
                    Head.previous = node;
                    Head = node;
                }
//                node.next = Head;
//                Head.previous.next = node;
//                node.previous = Head.previous;
//                Head.previous = node;
            }
            return true;
        }

        return false;
    }

    //            else if (size == 1) {
    //                if (priority < Head.priority) {
    //                    node.next = Head;
    //                    Head.previous.next = node;
    //                    node.previous = Head.previous;
    //                    Head.previous = node;
    //                    Head = node;
    //                } else if (priority < Head.priority) {
    //                    node.next = Head;
    //                    Head.previous.next = node;
    //                    node.previous = Head.previous;
    //                    Head.previous = node;
    //                } else if (data.compareTo(Head.data) < 0) {
    //                    node.next = Head;
    //                    Head.previous.next = node;
    //                    node.previous = Head.previous;
    //                    Head.previous = node;
    //                    Head = node;
    //                } else {
    //                    node.next = Head;
    //                    Head.previous.next = node;
    //                    node.previous = Head.previous;
    //                    Head.previous = node;
    //                }}
    public void print() {
        if (Head != null) {
            Node<N> T = Head;
            int i = 1;
            do {
                System.out.println("Data number " + (i++) + "  is  " + T.data + "   with priority   " + T.priority);
                T = T.next;
            } while (T != Head);

        }
    }

    private int get_max_priority() {
//        Node<N> temp = Head;
//        int max = -1;
//        for (int i = 0; i < size; i++, temp = temp.next) {
//            if (temp.priority > max) {
//                max = temp.priority;
//            }
//        }
//        return max;
        return Head == null ? 0 : Head.previous.priority;
    }

    public void InsertFromQueue(Queue<N> Q) {
//        System.out.println(" SIZEE "+Q.getSize());
        if (Q.getSize() > 0) {
            Queue.Node temp = Q.pop();
//            System.out.println(" SIZEE "+Q.getSize());
//                temp = Q.Head;        
//            System.out.println("tttt " + temp.data);

            N T = (N) temp.data;

            int p = temp.priority;
//            System.out.println("T   "+T+"    p    "+p);
            push_sorted(T, p);
//            System.out.println("TTTTTTTTTT");
        }
    }

}
