package com.multi;

import com.pholser.junit.quickcheck.Property;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.greaterThan;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;

import java.util.Optional;


/**
 * Created by Chaklader on 5/9/18.
 */

//Node{value=1,parent=null,children=[3,2]}
//Node{value=3,parent=1,children=[7,6]}
//Node{value=7,parent=3,children=[]}
//Node{value=6,parent=3,children=[]}
//Node{value=2,parent=1,children=[5,4]}
//Node{value=5,parent=2,children=[10]}
//Node{value=10,parent=5,children=[]}
//Node{value=4,parent=2,children=[8,9]}
//Node{value=8,parent=4,children=[]}
//Node{value=9,parent=4,children=[]}
public class App {

    private static Node createTree() {

        /*
        -------------------
                   1
                  / \
                 2   3
                / \ / \
               4  5 6 7
              / \ |
              8 9 10
        -------------------
        */

        Node root = new Node(1);
        root.add(
                new Node(2).add(
                        new Node(4).add(
                                new Node(8)).add(
                                new Node(9)
                        )).add(
                        new Node(5).add(new Node(10)
                        ))
        ).add(
                new Node(3).add(
                        new Node(6)).add(
                        new Node(7)
                ));
        return root;
    }

    private static void printNode(Node node) {
        System.out.println(node);
        for (Node child : node.children()) {
            printNode(child);
        }
    }

    public static void main(String... args) {
        Node root = createTree();
        printNode(root);
    }
}

