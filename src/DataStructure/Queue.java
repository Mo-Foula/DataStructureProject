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
public class Queue<N extends Comparable<N>> {

    class Node<N extends Comparable<N>> {

        N data;
        int priority;
        Node<N> previous, next;

        Node(N data, int a) {
            next = previous = null;
            this.data = data;
            priority = a;
        }
    }
    public Node<N> Head, Tail;
    int size = 0;

    public int getSize() {
        return size;
    }

    public N front() {
        if (size > 0) {
            return Tail.data;
        }
        return null;
    }

    public boolean empty() {
        return !(size > 0);
    }

    public boolean push(N data, int pri) {

        Node<N> node = new Node<>(data, pri);

        if (node != null) {
            size++;
            if (Head == null) {
                Head = node;
                Tail = node;

            } else {
//            System.out.println("QUEUEUEUEUEUE PUSH   "+data+"  "+Head.data);
                node.next = Head;
                Head.previous = node;
                Head = node;

            }
            return true;
        }
        return false;
    }

    public Node pop() {
        Node<N> d = Tail;
//        if(d!=null){
//            Tail = Tail.previous;
//            if(Tail == null)
//                Head = null;
//        }
        if (Head != null) {
            if (size == 1) {
//                System.out.println("tail  " + d.data);
                Tail = Head = null;
//                d.next . previous = null;
            } else if (size > 1) {
//                System.out.println("tail  " + d.data);
                Tail = Tail.previous;
                Tail.next = null;
                d.previous = null;

            }

            size--;
//            d = new Node<>(Tail.data , Tail.priority);
//            System.out.println("reached 3");
//            d = Tail;
//            System.out.println("reached 4");
//            System.out.println("reached 5");
//            System.out.println("nextt    "+Tail.data);
//            System.out.println("nextt    "+Tail.data);
//            System.out.println("reached 6");
//            System.out.println("dataaa "+d.data);
        }

        return d;
    }

    public N Npop() {
        return (N) pop().data;
    }

    public void InsertFromQueue(Queue<N> Q) {
//        return ;
        if (Q.getSize() > 0) {
//            System.out.println("SSSSSSSSSSSize  "+Q.getSize());
            Node<N> temp = Q.pop();
            if (temp == null) {
//                System.out.println("Q.size   " + Q.getSize() + "      TEMP    NULL    " + (temp == null));
            } else {
//                System.out.println("Q.size   " + Q.getSize() + "      TEMP    NULL    " + (temp == null));
                N D = temp.data;
                int P = temp.priority;
                push(temp.data, temp.priority);
            }
//            System.out.println("SSSSSSSSSSSize  "+Q.getSize());
//                temp = Q.Head;   
//System.out.println("temo ");
//System.out.println("temp da  "+temp.data+"   pri   "+temp.priority);

//            System.out.println("adadadadada");
        }
    }

    public void insertfrom_Stack(Stack<N> S) {
        if (S.size > 0) {
            int PRI;
            N Data;
//            System.out.println("1111111111111111111111");
//            S.print();
//            System.out.println("TRUEEE ?   ");
//            System.out.println("sizze " + S.size);
//            System.out.println("Length " + S.getSize());
            Stack.Node DD = S.pop();
            
//            System.out.println("Length " + S.getSize());
//            System.out.println("TRUEEE ?   " + (DD == null));
//            S.print();
//            System.out.println("1111111111111111111111");
            if (DD != null) {
                Data = (N) DD.data;
                PRI = DD.priority;
                push(Data, PRI);
            }
        }
    }

    public void insertfrom_CLL(LinkedListCircular<N> L) {
        if (L.size > 0) {
            int PRI;
            N Data;
            LinkedListCircular.Node DD = L.pop_back();
            Data = (N) DD.data;
            PRI = DD.priority;
//            System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLl     "+(L.size+1));
//            L.print();
//            System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLl     "+(L.size+1));
            
//            System.out.println("DATAAAAA "+Data+"      pri       "+PRI);
//            System.out.println("TBA3nAAAAAAAAA");
            push(Data, PRI);
//            System.out.println("TBA3nAAAAAAAAA");
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
