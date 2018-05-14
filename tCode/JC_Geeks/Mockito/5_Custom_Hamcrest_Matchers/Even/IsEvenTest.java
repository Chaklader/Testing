package com.multi;

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
import org.hamcrest.Matcher;
import org.w3c.dom.Node;

//import jdk.internal.org.xml.sax.InputSource;
import org.xml.sax.InputSource;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Chaklader on 5/14/18.
 */
public class IsEvenTest {

    @Test
    public void should_pass_for_even_number() throws Exception { // Given

        Integer test = 4;

        // Then
        assertThat(test, isEven());

        assertThat(test, not(isEven()));
    }
}