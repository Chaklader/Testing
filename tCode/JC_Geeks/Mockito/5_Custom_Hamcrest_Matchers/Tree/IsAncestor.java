package com.multi;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;


/*Next will check if a given Node is an ancestor
of an input Node. This operation is effectively
the opposite of*/
public class IsAncestor extends TypeSafeDiagnosingMatcher<Node> {

    private final Node descendant;

    public IsAncestor(Node descendant) {
        this.descendant = descendant;
    }

    @Override
    protected boolean matchesSafely(Node node, Description description) {
        Node descendantCopy = descendant;
        while (descendantCopy.parent() != null) {
            if (descendantCopy.parent().equals(node)) {
                return true;
            }
            descendantCopy = descendantCopy.parent();
        }
        description.appendText("a Node which was not an ancestor of ").appendValue(descendant);
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an ancestor Node of ").appendValue(descendant);
    }

    public static IsAncestor ancestorOf(Node descendant) {
        return new IsAncestor(descendant);
    }
}