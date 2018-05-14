package com.multi;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;


/*Next up is a matcher with input, we will check if a given Node
is a descendant of an input Node. We will move up through the
parents to see if we hit the test Node before a Root.*/
public class IsDescendant extends TypeSafeDiagnosingMatcher<Node> {
    private final Node ancestor;

    public IsDescendant(Node ancestor) {
        this.ancestor = ancestor;
    }

    @Override
    protected boolean matchesSafely(Node node, Description description) {
        while (node.parent() != null) {
            if (node.parent().equals(ancestor)) {
                return true;
            }
            node = node.parent();
        }
        description.appendText("a Node which was not a descendant of ").appendValue(ancestor);
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a descendant Node of ").appendValue(ancestor);
    }

    public static IsDescendant descendantOf(Node ancestor) {
        return new IsDescendant(ancestor);
    }
}