package com.multi;

public class IsDescendantTest {
    @Test
    public void should_pass_for_descendant_node() throws Exception { // Given
        Node node = NodeTestFixture.nine;
        Node ancestor = NodeTestFixture.two;
// Then
        assertThat(node, is(descendantOf(ancestor)));
    }

    @Test
    public void should_fail_for_non_descendant_node() throws Exception { // Given
        Node node = NodeTestFixture.ten;
        Node ancestor = NodeTestFixture.three;
// Then
        assertThat(node, is(not(descendantOf(ancestor))));
    }
}