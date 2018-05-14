package com.multi;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/*We will now create a matcher to check if a Node is the Root Node.
We will do this by checking for the presence of a parent Node.*/
public class IsRoot extends TypeSafeDiagnosingMatcher<Node> {
    @Override
    protected boolean matchesSafely(Node node, Description mismatchDescription) {
        if (node.parent() != null) {
            mismatchDescription.appendText("a node with parent ").appendValue(node.parent());
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a root node with no parent");
    }

    public static IsRoot root() {
        return new IsRoot();
    }
}