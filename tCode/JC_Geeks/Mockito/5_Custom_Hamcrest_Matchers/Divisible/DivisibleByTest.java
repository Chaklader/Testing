package com.multi;

import static com.multi.DivisibleBy.divisibleBy;
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

/**
 * Created by Chaklader on 5/14/18.
 */
public class DivisibleByTest {

    @Test
    public void should_pass_for_true_divisor() throws Exception { // Given

        Integer test = 15;
        // Then
        assertThat(test, is(divisibleBy(5)));
    }

    @Test
    public void should_fail_for_non_divisor() throws Exception { // Given

        Integer test = 17;
        // Then
        assertThat(test, is(divisibleBy(3)));
    }
}