package com.multi;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/* A common data structure in programming is a Tree made up of many nodes.
 * These nodes may have a single Parent or one or more Children. A node
 * which has no parents is called a Root. A node which has no children
 * is called a Leaf. A node X is considered a Descendant of another node
 * Y if a path can be traced from X to Y through the parent of X. A node
 * X is considered an Ancestor of another node Y if Y is a descendent of X.
 * A node X is considered a Sibling of another node Y if both X and Y share
 * a parent.*/
public class Node {

    private final int value;
    private Node parent;

    private final Set<Node> children;

    /**
     * Create a new Node with the input value
     */
    public Node(int value) {

        this.value = value;
        children = new HashSet<>();
    }

    /**
     * @return The value of this Node
     */
    public int value() {
        return value;
    }

    /**
     * @return The parent of this Node
     */
    public Node parent() {
        return parent;
    }

    public Set<Node> children() {
        return new HashSet<>(children);
    }

    /**
     * Add a child to this Node *
     *
     * @return this Node
     */
    public Node add(Node child) {
        if (child != null) {
            children.add(child);
            child.parent = this;
        }
        return this;
    }

    /**
     * Remove a child from this Node *
     *
     * @return this Node
     */
    public Node remove(Node child) {
        if (child != null && children.contains(child)) {
            children.remove(child);
            child.parent = null;
        }
        return this;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Node{")
                .append("value=").append(value).append(",").append("parent=").append(parent != null ? parent.value : "null").append(",").append("children=").append("[")
                .append(children.stream().map(n -> Integer.toString(n.value)).collect(Collectors.joining(","))).append("]}");

        return builder.toString();
    }
}
