package com.multi;

public class NodeTestFixture {

    static Node one = new Node(1);

    static Node two = new Node(2);

    static Node three = new Node(3);

    static Node four = new Node(4);

    static Node five = new Node(5);

    static Node six = new Node(6);

    static Node seven = new Node(7);

    static Node eight = new Node(8);

    static Node nine = new Node(9);

    static Node ten = new Node(10);


    static {
        one.add(two);
        one.add(three);

        two.add(four);
        two.add(five);

        three.add(six);
        three.add(seven);

        four.add(eight);
        four.add(nine);

        five.add(ten);

    }

}