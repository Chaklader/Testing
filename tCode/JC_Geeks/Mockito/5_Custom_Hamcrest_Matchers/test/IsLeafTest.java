package com.multi;

import org.junit.Test;

import static com.multi.IsLeaf.leaf;
import static com.multi.IsEven.isEven;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.*;


import org.junit.Test;

public class IsLeafTest extends NodeTestFixture {
    @Test
    public void should_pass_for_leaf_node() throws Exception { // Given

        Node node = NodeTestFixture.seven;
        // Then
        assertThat(node, is(leaf()));
    }

    @Test
    public void should_fail_for_non_leaf_node() throws Exception { // Given
        Node node = NodeTestFixture.four;

        // Then
        assertThat(node, is(not(leaf())));
    }
}