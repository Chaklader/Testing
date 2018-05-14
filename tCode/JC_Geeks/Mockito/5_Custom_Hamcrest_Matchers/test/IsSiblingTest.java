package com.multi;

import static com.multi.DivisibleBy.divisibleBy;
import static com.multi.IsSibling.siblingOf;
import static org.junit.Assert.*;
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


public class IsSiblingTest {
    
    @Test
    public void should_pass_for_sibling_node() throws Exception {
    
        // Given
        Node a = NodeTestFixture.four;
        Node b = NodeTestFixture.five;

        // Then
        assertThat(a, is(siblingOf(b)));
    }

    @Test
    public void should_fail_for_testing_root_node() throws Exception {
    
        // Given
        Node a = NodeTestFixture.one;
        Node b = NodeTestFixture.six;

        // Then
        assertThat(a, is(not(siblingOf(b))));
    }

    @Test
    public void should_fail_for_input_root_node() throws Exception {
        
        // Given
        Node a = NodeTestFixture.five;
        Node b = NodeTestFixture.one;

        // Then
        assertThat(a, is(not(siblingOf(b))));
    }

    @Test
    public void should_fail_for_non_sibling_node() throws Exception {
        
        // Given
        Node a = NodeTestFixture.five;
        Node b = NodeTestFixture.six;

        // Then
        assertThat(a, is(not(siblingOf(b))));
    }
}
