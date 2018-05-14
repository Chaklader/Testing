package com.multi;

public class IsAncestorTest {

    @Test
    public void should_pass_for_ancestor_node() throws Exception { // Given

        Node node = NodeTestFixture.two;
        Node descendant = NodeTestFixture.ten;

        // Then
        assertThat(node, is(ancestorOf(descendant)));
    }

    @Test
    public void should_fail_for_non_ancestor_node() throws Exception { // Given

        Node node = NodeTestFixture.three;
        Node descendant = NodeTestFixture.eight;

        // Then
        assertThat(node, is(not(ancestorOf(descendant))));
    }
}