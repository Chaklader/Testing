package com.multi;

import org.junit.Test;

import static com.multi.IsAncestor.ancestorOf;
import static com.multi.IsRoot.root;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class IsRootTest {
    @Test
    public void should_pass_for_root_node() throws Exception { // Given
        Node node = NodeTestFixture.one;
        
        // Then
        assertThat(node, is(root()));
    }

    @Test
    public void should_fail_for_non_root_node() throws Exception { // Given
        Node node = NodeTestFixture.five;
        
        // Then
        assertThat(node, is(not(root())));
    }
}