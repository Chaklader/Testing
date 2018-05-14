package com.multi;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;


/*Lastly we will create a Matcher to check if an input Node is a sibling of another
* node. We will check if they share a parent. In addition we will do some checks and
* provide some outputs for when the user tries to test root nodes for siblings*/
public class IsSibling extends TypeSafeDiagnosingMatcher<Node> {

    private final Node sibling;

    public IsSibling(Node sibling) {
        this.sibling = sibling;
    }

    @Override
    protected boolean matchesSafely(Node node, Description description) {
        if (sibling.parent() == null) {
            description.appendText("input root node cannot be tested for siblings");
            return false;
        }
        if (node.parent() != null && node.parent().equals(sibling.parent())) {
            return true;
        }

        if (node.parent() == null) {
            description.appendText("a root node with no siblings");
        } else {
            description.appendText("a node with parent ").appendValue(node.parent());
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        if (sibling.parent() == null) {
            description.appendText("a sibling of a root node");
        } else {
            description.appendText("a node with parent ").appendValue(sibling.parent());
        }
    }

    public static IsSibling siblingOf(Node sibling) {
        return new IsSibling(sibling);
    }
}
                