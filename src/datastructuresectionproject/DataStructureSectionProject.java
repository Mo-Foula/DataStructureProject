package datastructuresectionproject;

import DataStructure.*;
import java.util.Random;

public class DataStructureSectionProject {

    static int Gen = 1;

    public static int Generator() {
        return (Gen++);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    static int Random_1to5() {
        return getRandomNumberInRange(1, 5);
    }

    static int Min_Length(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    static int Max_Length(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    static int Random_1to4() {
        return getRandomNumberInRange(1, 4);
    }

    public static void main(String[] args) {
        Queue<Integer> Q1;
        int E, EE;
        boolean[] AR = new boolean[101];

        for (int i = 0; i < 10000; i++) {
            
           
            for (int k = 0; k < 101; k++) {
                AR[k] = false;
            }
            Q1 = A();
            E = 100;
            while (E-- > 0) {
//                 System.out.println("AEAEAEAEE");
                EE = Q1.Npop();
                if (AR[EE] == true) {
                    System.out.println("wrong data "+EE);
                    Q1.print();
                    System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
                }
                else
                    AR[EE] = true;
            }
        }

    }

    static Queue<Integer> A() {
        int Gen = 1;
        Stack<Integer> S = new Stack<>();
        Queue<Integer> Q1 = new Queue<>();
        Queue<Integer> Q2 = new Queue<>();
        Queue<Integer> Q3 = new Queue<>();
        Queue<Integer> Q4 = new Queue<>();

        LinkedListCircular<Integer> L = new LinkedListCircular<>();

        int counter = 0;
        int A, B;
//        Boolean F = false;
//        while (Q3.getSize() < 100) {
        while (counter < 100) {
            A = Random_1to4();
            int i = 1;
            switch (A) {
                case 1:
//                         System.out.println("11111111");
                    if (Gen <= 100) {
                        Q1.push(Gen++, Random_1to5());
//                         System.out.println("GEN is "+(Gen-1)+" number "+(i++));
                    }
//                        System.out.println("\n\nQ1 Q1 Q1 Q1 Q1 ");
//                        Q1.print();
//                        System.out.println("Q1 Q1 Q1 Q1 Q1 \n\n");
                    break;
                case 2:
                    if (Q1.getSize() > 0) {
                        if (S.getSize() == L.getSize() && S.getSize() == Q2.getSize()) {

                            B = getRandomNumberInRange(1, 3);
                            switch (B) {
                                case 1: //S
                                    S.InsertFromQueue(Q1);
                                    break;
                                case 2: //Q2
                                    Q2.InsertFromQueue(Q1);
                                    break;
                                case 3: //L
//                                    System.out.println("4444444444");
                                    L.InsertFromQueue(Q1);
                                    break;
                            }
                        } else if (S.getSize() == L.getSize() && Q2.getSize() > Min_Length(S.getSize(), Q2.getSize(), L.getSize())) {
                            B = getRandomNumberInRange(1, 2);
                            switch (B) {
                                case 1:
                                    S.InsertFromQueue(Q1);
                                    break;
                                case 2:
//                                    System.out.println("4444444444");
                                    L.InsertFromQueue(Q1);
                                    break;
                            }
                        } else if (Q2.getSize() == L.getSize() && S.getSize() > Min_Length(S.getSize(), Q2.getSize(), L.getSize())) {
                            B = getRandomNumberInRange(1, 2);
                            switch (B) {
                                case 1:
                                    Q2.InsertFromQueue(Q1);
                                    break;
                                case 2:
//                                    System.out.println("4444444444");
                                    L.InsertFromQueue(Q1);
                                    break;
                            }
                        } else if (S.getSize() == Q2.getSize() && L.getSize() > Min_Length(S.getSize(), Q2.getSize(), L.getSize())) {
                            B = getRandomNumberInRange(1, 2);
                            switch (B) {
                                case 1:
                                    S.InsertFromQueue(Q1);
                                    break;
                                case 2:
                                    Q2.InsertFromQueue(Q1);
                                    break;
                            }
                        } else {
                            B = Min_Length(S.getSize(), Q2.getSize(), L.getSize());
                            if (B == S.getSize()) {
//                        System.out.println("22222222");
                                S.InsertFromQueue(Q1);
                            } else if (B == L.getSize()) {
//                        System.out.println("4444444444");
                                L.InsertFromQueue(Q1);
                            } else {
//                        System.out.println("555555555");
                                Q2.InsertFromQueue(Q1);
                            }
                        }
                    }
                    break;

                case 3:
//                        System.out.println("3333333333333");
                    if (Max_Length(S.getSize(), Q2.getSize(), L.getSize()) > 0) {
                        if (S.getSize() == L.getSize() && S.getSize() == Q2.getSize() && S.getSize() > 0) {
                            B = getRandomNumberInRange(1, 3);
                            switch (B) {
                                case 1: //S
                                    Q3.insertfrom_Stack(S);
                                    break;
                                case 2: //Q2
                                    Q3.InsertFromQueue(Q2);
                                    break;
                                case 3: //L
                                    Q3.insertfrom_CLL(L);
                                    break;
                            }
                        } else if (S.getSize() == L.getSize() && S.getSize() > 0 && Q2.getSize() < Max_Length(S.getSize(), Q2.getSize(), L.getSize())) {
                            B = getRandomNumberInRange(1, 2);
                            switch (B) {
                                case 1:
                                    Q3.insertfrom_Stack(S);
                                    break;
                                case 2:
                                    Q3.insertfrom_CLL(L);
                                    break;
                            }
                        } else if (Q2.getSize() == L.getSize() && L.getSize() > 0 && S.getSize() < Max_Length(S.getSize(), Q2.getSize(), L.getSize())) {
                            B = getRandomNumberInRange(1, 2);
                            switch (B) {
                                case 1:
                                    Q3.InsertFromQueue(Q2);
                                    break;
                                case 2:
                                    Q3.insertfrom_CLL(L);
                                    break;
                            }
                        } else if (S.getSize() == Q2.getSize() && Q2.getSize() > 0 && L.getSize() < Max_Length(S.getSize(), Q2.getSize(), L.getSize())) {
                            B = getRandomNumberInRange(1, 2);
                            switch (B) {
                                case 1:
                                    Q3.insertfrom_Stack(S);
                                    break;
                                case 2:
                                    Q3.InsertFromQueue(Q2);
                                    break;
                            }
                        } else {
                            B = Max_Length(S.getSize(), Q2.getSize(), L.getSize());
                            if (B > 0) {
                                if (B == S.getSize()) {
                                    Q3.insertfrom_Stack(S);
                                } else if (B == L.getSize()) {
                                    Q3.insertfrom_CLL(L);
                                } else {
                                    Q3.InsertFromQueue(Q2);
                                }
                            }

                        }
                    }
                    break;

                case 4:
//                        System.out.println("44444444444");
                    if (Q3.getSize() > 0) {
//                        F = true;
//                        System.out.println("Q3Q3Q3    "+Q3.getSize());
//                        System.out.println("Q3Q3Q3");
//                        Q3.print();
//                        System.out.println("Q3Q3Q3       " + Q3.getSize());

                        Q4.InsertFromQueue(Q3);
                        counter++;
//                        System.out.println("Number " + (++counter) + " is " + Q3.Npop());
//                        System.out.println(Q3.Npop());
//                            if (Q3.getSize() == 100) {
//                                Q3.print();
//                            }
                    }
                    break;
            }
//            if(F==true)
//                break;
        }
        return Q4;
    }
}

//        S.push(111, 5);
//        S.push(2, 1);
//        S.push(3, 2);
//        S.push(1, 5);
//        S.push(4, 4);
//        S.push(5, 2);
//        S.print();
//        
//                Q1.push(111, 5);
//        Q1.push(2, 1);
//        Q1.push(3, 2);
//        Q1.push(1, 5);
//        Q1.push(4, 4);
//        Q1.push(5, 2);
//        Q1.print();
//        System.out.println("stack  "+S.pop());
//        System.out.println("stack  "+Q1.Npop());
//        L.push_sorted(111, 5);
//        System.out.println("2nd   "+L.push_sorted(1, 1));;
//        L.push_sorted(2, 2);
//        L.push_sorted(17, 3);
//        L.push_sorted(4, 3);
//        L.push_sorted(3, 5);
//        L.push_sorted(20, 2);
//        L.push_sorted(11, 2);
//        L.print();
//        Queue<Integer> Q1 = new Queue<>();
//        Q1.push(1, 5);
//        Q1.push(4, 4);
//        Q1.push(111, 2);
//        Q1.push(2, 1);
//        Q1.push(44, 3);
//
//        System.out.println("stack Q1.size  " + Q1.getSize());
//        Q1.print();
//        Q1.pop();
//        System.out.println("stack Q1.size  " + Q1.getSize());
//        Q1.print();
//        Q1.pop();
//        System.out.println("stack Q1.size  " + Q1.getSize());
//        Q1.print();
//        Q1.pop();
//        System.out.println("stack Q1.size  " + Q1.getSize());
//        Q1.print();
//        Q1.pop();
//        System.out.println("stack Q1.size 1 " + Q1.getSize());
////        System.out.println("Q1  "+Q1.Head);
//        Q1.print();
//        Q1.pop();
//        System.out.println("stack Q1.size 1 " + Q1.getSize());
////        System.out.println("Q1  "+Q1.Head);
//        Q1.print();
//        Q1.pop();
//        System.out.println("stack Q1.size 1 " + Q1.getSize());
////        System.out.println("Q1  "+Q1.Head);
//        Q1.print();
//        Q1.pop();
////        System.out.println("stack Q1.size  " + Q1.getSize());
////        Q1.print();
////        Q1.pop();
////        System.out.println("stack Q1.size  " + Q1.getSize());
//        S.push(1, 2);
//        S.push(2, 1);
//        S.push(44, 3);
//        S.push(111, 1);
//        S.push(10, 5);
//        S.push(3, 4);
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        S.print();
//        S.pop();
//        System.out.println("Stack size " + S.getSize());
//        L.InsertFromQueue(Q2);
//        L.print();
//
////        S.pop();
//        L.InsertFromQueue(Q1);
//        L.InsertFromQueue(Q1);
//        System.out.println("L size " + L.getSize());
//        L.print();
//        L.pop_back();
//        System.out.println("L size " + L.getSize());
//        L.print();        
//Queue<Integer> Q1 = new Queue<>();
//        Queue<Integer> Q2 = new Queue<>();
//        LinkedListCircular<Integer> L = new LinkedListCircular<>();
//        Q1.push(1, 5);
//        Q1.push(4, 4);
//        Q1.push(111, 2);
//        Q1.push(2, 1);
//        Q1.push(44, 3);
//
//        Stack<Integer> S = new Stack<>();
//        A();
//    }static void A() {
//        Queue<Integer> A = new Queue();
//        A.push
