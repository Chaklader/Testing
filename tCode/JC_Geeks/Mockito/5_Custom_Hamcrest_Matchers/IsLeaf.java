package com.multi;



import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/*The first Matcher we will create will check if the input node is
a leaf node. It will accomplish this by checking if the input node
has any children, if it does then it is not a leaf node.*/
public class IsLeaf extends TypeSafeDiagnosingMatcher<Node> {

    @Override
    protected boolean matchesSafely(Node node, Description mismatchDescription) {
        if (!node.children().isEmpty()) {
            mismatchDescription.appendText("a node with ").appendValue(node.children().size()).appendText(" children");
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a leaf node with no children");
    }

    public static IsLeaf leaf() {
        return new IsLeaf();
    }
}