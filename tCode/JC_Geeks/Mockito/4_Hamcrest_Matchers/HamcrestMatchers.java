package com.multi;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.*;

import org.hamcrest.Matcher;
import org.junit.Test;

import javax.swing.*;
import javax.swing.event.MenuEvent;


public class HamcrestMatchers {

    /*
     * any(): Matches any variable of the given type.
     * */
    @Test
    public void test_any() throws Exception {
        // Given
        String myString = "hello";
        // Then
        assertThat(myString, is(any(String.class)));
    }


    /*
     * anything(): Matches anything
     * */
    @Test
    public void test_anything() throws Exception {
        // Given
        String myString = "hello";
        Integer four = 4;
        // Then
        assertThat(myString, is(anything()));
        assertThat(four, is(anything()));
    }


    /*
     * arrayContaining(): Various matchers for Arrays, length of the
     * array must match the number of matchers, and their order is
     * important.
     * */

    // Does the array contain all given items in the order in which they are input to the matcher?
    @Test
    public void test_arrayContaining_items() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        assertThat(strings, is(arrayContaining("why", "hello", "there")));
    }

    // Does the array contain items which match the input list of matchers, in order?
    @Test
    public void test_arrayContaining_list_of_matchers() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        java.util.List<org.hamcrest.Matcher<? super String>> itemMatchers = new ArrayList<>();
        itemMatchers.add(equalTo("why"));
        itemMatchers.add(equalTo("hello"));
        itemMatchers.add(endsWith("here"));
        assertThat(strings, is(arrayContaining(itemMatchers)));
    }

    // Does the array contain items which match the input vararg matchers, in order?
    @Test
    public void test_arrayContaining_matchers() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        assertThat(strings, is(arrayContaining(startsWith("wh"), equalTo("hello"), endsWith("here"))));
    }


    /*
     * arrayContainingInAnyOrder(): Various matchers for Arrays, length of the
     * array must match the number of matchers, but their order is not important.
     * */

    // Does the array contain all the given items?
    @Test
    public void test_arrayContainingInAnyOrder_items() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        assertThat(strings, is(arrayContainingInAnyOrder("hello", "there", "why")));
    }

    // Does the array contain items which match the input collection of Matchers?
    @Test
    public void test_arrayContainingInAnyOrder_collection_of_matchers() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        Set<Matcher<? super String>> itemMatchers = new HashSet<>();
        itemMatchers.add(equalTo("hello"));
        itemMatchers.add(equalTo("why"));
        itemMatchers.add(endsWith("here"));
        assertThat(strings, is(arrayContainingInAnyOrder(itemMatchers)));
    }

    // Does the array contain items which match the input vararg matchers?
// view sourceprint?
    @Test
    public void test_arrayContainingInAnyOrder_matchers() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        assertThat(strings, is(arrayContainingInAnyOrder(endsWith("lo"), startsWith("the"), equalTo("why"))));
    }


    /*
     * arrayWithSize(): Various matchers to check
     * if an array is of a certain length.
     * */
// Does the input array have exactly the specified length?
    @Test
    public void test_arrayWithSize_exact() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        assertThat(strings, is(arrayWithSize(3)));
    }

    // Does the input array have a length which matches the specified matcher?
// view sourceprint?
    @Test
    public void test_arrayWithSize_matcher() throws Exception {
        // Given
        String[] strings = {"why", "hello", "there"};
        // Then
        assertThat(strings, is(arrayWithSize(greaterThan(2))));
    }

    /*
     * closeTo(): Matcher which can be used with either Double or BigDecimal
     * to check if a value is within a specified error margin of an expected
     * value.
     * */
// Double
    @Test
    public void test_closeTo_double() throws Exception {
        // Given
        Double testValue = 6.3;
        // Then
        assertThat(testValue, is(closeTo(6, 0.5)));
    }

    // BigDecimal
    @Test
    public void test_closeTo_bigDecimal() throws Exception {
        // Given
        BigDecimal testValue = new BigDecimal(324.0);
        // Then
        assertThat(testValue, is(closeTo(new BigDecimal(350), new BigDecimal(50))));
    }


    /*
    * comparesEqualTo(): Creates a Comparable matcher which attempts to match the input 
    * matcher value using the compareTo() method of the input value. The matcher will 
    * match if the compareTo() method returns 0 for the input matcher value, otherwise 
    * it would not match.
    * */
    @Test
    public void test_comparesEqualTo() throws Exception {
        // Given
        String testValue = "value";
        // Then
        assertThat(testValue, comparesEqualTo("value"));
    }


    /*
    * contains(): Various matchers which can be used to check if an input 
    * Iterable contains values. The order of the values is important and 
    * the number of items in the Iterable must match the number of values 
    * being tested.
    * */
    // Does the input list contain all of the values, in order?
    @Test
    public void test_contains_items() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");
        // Then
        assertThat(strings, contains("why", "hello", "there"));
    }

    // Does the input list contain items which match all of the matchers in the input matchers list, in order?
    @Test
    public void test_contains_list_of_matchers() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");
        // Then
        List<org.hamcrest.Matcher<? super String>> matchers = new ArrayList<>();
        matchers.add(startsWith("wh"));
        matchers.add(endsWith("lo"));
        matchers.add(equalTo("there"));
        assertThat(strings, contains(matchers));
    }

    // Does the input list contain only one item which matches the input matcher?
    @Test
    public void test_contains_single_matcher() throws Exception {
        // Given
        List<String> strings = Arrays.asList("hello");
        // Then
        assertThat(strings, contains(startsWith("he")));
    }

    // Does the input list contain items which match all of the matchers in the input vararg matchers, in order?
// view sourceprint?
    @Test
    public void test_contains_matchers() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");
        // Then
        assertThat(strings, contains(startsWith("why"), endsWith("llo"), equalTo("there")));
    }

    /*
    * containsInAnyOrder(): Various matchers which can be used to check if an input Iterable 
    * contains values. The order of the values is not important but the number of items in the 
    * Iterable must match the number of values being tested.
    * */
// Does the input list contain all of the values, in any order?
    @Test
    public void test_containsInAnyOrder_items() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");
        // Then
        assertThat(strings, containsInAnyOrder("hello", "there", "why"));
    }

    // Does the input list contain items which match all of the matchers in the input matchers list, in any order?
    @Test
    public void test_containsInAnyOrder_list_of_matchers() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");
        // Then
        List<org.hamcrest.Matcher<? super String>> matchers = new ArrayList<>();
        matchers.add(equalTo("there"));
        matchers.add(startsWith("wh"));
        matchers.add(endsWith("lo"));
        assertThat(strings, containsInAnyOrder(matchers));
    }

    // Does the input list contain items which match all of the matchers in the input vararg matchers, in any order?
    // view sourceprint?
    @Test
    public void test_containsInAnyOrder_matchers() throws Exception {
        // Given
        List<String> strings = Arrays.asList("why", "hello", "there");
        // Then
        assertThat(strings, containsInAnyOrder(endsWith("llo"), equalTo("there"), startsWith("why")));
    }


    /*
    * containsString(): Matcher which matches if the
    * String under test contains the given substring.
    * */
    @Test
    public void test_containsString() throws Exception {
        // Given
        String testValue = "value";
        // Then
        assertThat(testValue, containsString("alu"));
    }


    /*
    * empty(): Matcher which matches if an input 
    * Collections isEmpty() method returns true.
    * */
// view sourceprint?
    @Test
    public void test_empty() throws Exception {
        // Given
        Set<String> testCollection = new HashSet<>();
        // Then
        assertThat(testCollection, is(empty()));
    }


    /*
    * emptyArray(): Matcher which matches 
    * if the input array has a length of 0
    * */
    @Test
    public void test_emptyArray() throws Exception {
        // Given
        String[] testArray = new String[0];
        // Then
        assertThat(testArray, is(emptyArray()));
    }



    /*
    * emptyCollectionOf(): Typesafe matcher which matches 
    * if the input collection is of the given type and is 
    * empty.
    * */
// view sourceprint?
    @Test
    public void test_emptyCollectionOf() throws Exception {
        // Given
        Set<String> testCollection = new HashSet<>();
        // Then
        assertThat(testCollection, is(emptyCollectionOf(String.class)));
    }


    /*
    * emptyIterable(): Matcher which matches 
    * if the input Iterable has no values.
    * */
    @Test
    public void test_emptyIterable() throws Exception {
        // Given
        Set<String> testCollection = new HashSet<>();
        // Then
        assertThat(testCollection, is(emptyIterable()));
    }


    /*
    * emptyIterableOf(): Typesafe Matcher which matches if the 
    * input Iterable has no values and is of the given type.
    * */
    // view sourceprint?
    @Test
    public void test_emptyIterableOf() throws Exception {
        // Given
        Set<String> testCollection = new HashSet<>();
        // Then
        assertThat(testCollection, is(emptyIterableOf(String.class)));
    }


    /*
    * endsWith(): Matcher which matches if the 
    * input String ends with the given substring.
    * */
    @Test
    public void test_endsWith() throws Exception {
        // Given
        String testValue = "value";
        // Then
        assertThat(testValue, endsWith("lue"));
    }


    /*
    * equalTo(): Matcher which matches if the input value is logically equal to the given test 
    * value. Can also be used on Arrays in which case it will check the length of the Array and 
    * ensure that all the values in the input test array are logically equal to the values of 
    * the specified array.
    * */
    // Single value.
    @Test
    public void test_equalTo_value() throws Exception {
        // Given
        String testValue = "value";
        // Then
        assertThat(testValue, equalTo("value"));
    }

    // Array.
    // view sourceprint?
    @Test
    public void test_equalTo_array() throws Exception {
        // Given
        String[] testValues = {"why", "hello", "there"};
        // Then
        String[] specifiedValues = {"why", "hello", "there"};
        assertThat(testValues, equalTo(specifiedValues));
    }

    /*
    * equalToIgnoringCase(): Matcher which matches if the input 
    * String value is equal to the specified String while ignoring 
    * case.
    * */
    @Test
    public void test_equalToIgnoringCase() throws Exception {
        // Given
        String testValue = "value";
        // Then
        assertThat(testValue, equalToIgnoringCase("VaLuE"));
    }


    /*
    * equalToIgnoringWhiteSpace(): Matcher which matches if the input String value is equal 
    * to the specified String while ignoring superfluous white space. All leading and trailing 
    * whitespace are ignored, and all remaining whitespace is collapsed to a single space.
    * */
    // view sourceprint?
    @Test
    public void test_equalToIgnoringWhiteSpace() throws Exception {
        // Given
        String testValue = "this    is   my    value    ";
        // Then
        assertThat(testValue, equalToIgnoringWhiteSpace("this is my value"));
    }


    /*
    * eventFrom(): Matcher which matches if an input EventObject 
    * is from the given Source. Can also accept an EventObeject 
    * of a specified subtype.
    * */
    @Test
    public void test_eventFrom() throws Exception {
        // Given
        Object source = new Object();
        EventObject testEvent = new EventObject(source);
        // Then
        assertThat(testEvent, is(eventFrom(source)));
    }

    // With subtype specified.
    @Test
    public void test_eventFrom_type() throws Exception {
        // Given
        Object source = new Object();
        EventObject testEvent = new MenuEvent(source);
        // Then
        assertThat(testEvent, is(eventFrom(MenuEvent.class, source)));
    }


    /*
    * greaterThan(): Matcher which matches if an input 
    * test value is greater than a specified value.
    * */
    @Test
    public void test_greaterThan() throws Exception {
        // Given
        Integer testValue = 5;
        // Then
        assertThat(testValue, is(greaterThan(3)));
    }


    /*
    * greaterThanOrEqual(): Matcher which matches if an input 
    * test value is greater than or equal to a specified value.
    * */
    @Test
    public void test_greaterThanOrEqualTo() throws Exception {
        // Given
        Integer testValue = 3;
        // Then
        assertThat(testValue, is(greaterThanOrEqualTo(3)));
    }


    /*
    * hasEntry(): Matchers which match if a given map contains an 
    * entry which matches the specified key and value, or matchers.
    * */
    // Actual Values
    @Test
    public void test_hasEntry() throws Exception {
        // Given
        Integer testKey = 1;
        String testValue = "one";
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(testKey, testValue);
        // Then
        assertThat(testMap, hasEntry(1, "one"));
    }

    // Matchers
    @Test
    public void test_hasEntry_matchers() throws Exception {
        // Given
        Integer testKey = 2;
        String testValue = "two";
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(testKey, testValue);
        // Then
        assertThat(testMap, hasEntry(greaterThan(1), endsWith("o")));
    }


    /*
    * hasItem(): Matchers which match if the input Iterable has at 
    * least one item that matches the specified value or matcher.
    * */
    // Actual Value
    @Test
    public void test_hasItem() throws Exception {
        // Given
        List<Integer> testList = Arrays.asList(1, 2, 7, 5, 4, 8);
        // Then
        assertThat(testList, hasItem(4));
    }

    // Matcher
    @Test
    public void test_hasItem_matcher() throws Exception {
        // Given
        List<Integer> testList = Arrays.asList(1, 2, 7, 5, 4, 8);
        // Then
        assertThat(testList, hasItem(is(greaterThan(6))));
    }


    /*
    * hasItemInArray(): Matchers which match if the input Array 
    * has at least one item that matches the specified value or 
    * matcher.
    * */
    // Actual Value
    @Test
    public void test_hasItemInArray() throws Exception {
        // Given
        Integer[] test = {1, 2, 7, 5, 4, 8};
        // Then
        assertThat(test, hasItemInArray(4));
    }

    // Matcher
    @Test
    public void test_hasItemInArray_matcher() throws Exception {
        // Given
        Integer[] test = {1, 2, 7, 5, 4, 8};
        // Then
        assertThat(test, hasItemInArray(is(greaterThan(6))));
    }


    /*
    * hasItems(): Matchers which match if the input Iterable has 
    * all of the specified values or matchers, in any order.
    * */
    // Actual Values
    public void test_hasItems() throws Exception {
        // Given
        List<Integer> testList = Arrays.asList(1, 2, 7, 5, 4, 8);
        // Then
        assertThat(testList, hasItems(4, 2, 5));
    }

    // Matchers
    @Test
    public void test_hasItems_matcher() throws Exception {
        // Given
        List<Integer> testList = Arrays.asList(1, 2, 7, 5, 4, 8);
        // Then
        assertThat(testList, hasItems(greaterThan(6), lessThan(2)));
    }


    /*
    * hasKey(): Matchers which match if the input Map has 
    * at least one key which matches the specified value 
    * or matcher.
    * */
    // Actual Value
    @Test
    public void test_hasKey() throws Exception {
        // Given
        Map<String, String> testMap = new HashMap<>();
        testMap.put("hello", "there");
        testMap.put("how", "are you?");
        // Then
        assertThat(testMap, hasKey("hello"));
    }

    // Matcher
    @Test
    public void test_hasKey_matcher() throws Exception {
        // Given
        Map<String, String> testMap = new HashMap<>();
        testMap.put("hello", "there");
        testMap.put("how", "are you?");
        // Then
        assertThat(testMap, hasKey(startsWith("h")));
    }


    /*
    * hasProperty(): Matcher which matches if the input Object satisfies 
    * the Bean Convention and has a property with the specified name and 
    * optionally the value of the property matches the specified matcher.
    * */
    // Property Name
    @Test
    public void test_hasProperty() throws Exception {
        // Given
        JTextField testBean = new JTextField();
        testBean.setText("Hello, World!");
        // Then
        assertThat(testBean, hasProperty("text"));
    }

    // Property Name and Value Matcher
    @Test
    public void test_hasProperty_value() throws Exception {
        // Given
        JTextField testBean = new JTextField();
        testBean.setText("Hello, World!");
        // Then
        assertThat(testBean, hasProperty("text", startsWith("H")));
    }



    /*
    * hasSize(): Matchers which match if the input Collection has 
    * the specified size, or it’s size matches the specified matcher.
    * */
    // Actual Value
    @Test
    public void test_hasSize() throws Exception {
        // Given
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5);
        // Then
        assertThat(testList, hasSize(5));
    }

    // Matcher
    @Test
    public void test_hasSize_matcher() throws Exception {
        // Given
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5);
        // Then
        assertThat(testList, hasSize(lessThan(10)));
    }

    /*
     * hasToString(): Matchers which match if the input Object’s toString()
     * method matches either the specified String or the input matcher.
     * */

    // Atual Value
    @Test
    public void test_hasToString() throws Exception {
        // Given
        Integer testValue = 4;
        // Then
        assertThat(testValue, hasToString("4"));
    }

    // Matcher
    @Test
    public void test_hasToString_matcher() throws Exception {
        // Given
        Double testValue = 3.14;
        // Then
        assertThat(testValue, hasToString(containsString(".")));
    }

    /*
     * hasValue(): Matchers which match if the input Map has at
     * least one value that matches the specified value or matcher.
     * */
    // Actual Value
    @Test
    public void test_hasValue() throws Exception {
        // Given
        Map<String, String> testMap = new HashMap<>();
        testMap.put("hello", "there");
        testMap.put("how", "are you?");
        // Then
        assertThat(testMap, hasValue("there"));
    }

    // Matcher
    @Test
    public void test_hasValue_matcher() throws Exception {
        // Given
        Map<String, String> testMap = new HashMap<>();
        testMap.put("hello", "there");
        testMap.put("how", "are you?");
        // Then
        assertThat(testMap, hasValue(containsString("?")));
    }




    /*
    * hasXPath(): Matchers which match if the input XML 
    * DOM Node satisfies the input XPath expression
    * */

    // Does the Node contain a Node which matches the input XPath expression?
//    @Test
//    public void test_hasXPath() throws Exception {
//        // Given
//        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        Node testNode = docBuilder.parse(
//                new InputSource(new StringReader("<xml><top><middle><bottom>value</bottom></middle></top></xml>")))
//                .getDocumentElement();
//        // Then
//        assertThat(testNode, hasXPath("/xml/top/middle/bottom"));
//    }

    
    
    
    // Does the Node contain a Node which matches the input XPath expression and does that Node have a value which matches the specified matcher?
//    @Test
//    public void test_hasXPath_matcher() throws Exception {
//        // Given
//        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        Node testNode = docBuilder.parse(
//                new InputSource(new StringReader("<xml><top><middle><bottom>value</bottom></middle></top></xml>")))
//                .getDocumentElement();
//        // Then
//        assertThat(testNode, hasXPath("/xml/top/middle/bottom", startsWith("val")));
//    }

    
    
    // Does the Node contain a Node in the specified namespace which matches the input XPath expression?
//    @Test
//    public void test_hasXPath_namespace() throws Exception {
//        // Given
//        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//        docFactory.setNamespaceAware(true);
//        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//        Node testNode = docBuilder.parse(
//                new InputSource(new StringReader("<xml xmlns:prefix='http://namespace-uri'><top><middle><prefix:bottom>value</prefix:bottom></middle></top></xml>")))
//                .getDocumentElement();
//        NamespaceContext namespace = new NamespaceContext() {
//            public String getNamespaceURI(String prefix) {
//                return "http://namespace-uri";
//            }
//
//            public String getPrefix(String namespaceURI) {
//                return null;
//            }
//
//            public Iterator<String> getPrefixes(String namespaceURI) {
//                return null;
//            }
//        };
//        // Then
//        assertThat(testNode, hasXPath("//prefix:bottom", namespace));
//    }

    
    
    // Does the Node contain a Node in the specified namespace which matches the input XPath expression and does that Node have a value which matches the specified matcher?
//    @Test
//    public void test_hasXPath_namespace_matcher() throws Exception {
//        // Given
//        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//        docFactory.setNamespaceAware(true);
//        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//        Node testNode = docBuilder.parse(
//                new InputSource(new StringReader("<xml xmlns:prefix='http://namespace-uri'><top><middle><prefix:bottom>value</prefix:bottom></middle></top></xml>")))
//                .getDocumentElement();
//        NamespaceContext namespace = new NamespaceContext() {
//            public String getNamespaceURI(String prefix) {
//                return "http://namespace-uri";
//            }
//
//            public String getPrefix(String namespaceURI) {
//                return null;
//            }
//
//            public Iterator<String> getPrefixes(String namespaceURI) {
//                return null;
//            }
//        };
//        // Then
//        assertThat(testNode, hasXPath("//prefix:bottom", namespace, startsWith("val")));
//    }


    /*
    * instanceOf(): Matcher which matches if 
    * the input object is of the given type.
    * */
    @Test
    public void test_instanceOf() throws Exception {
        // Given
        Object string = "Hello, World!";
        // Then
        assertThat(string, instanceOf(String.class));
    }


    /*
    * isEmptyOrNullString(): Matcher which matches 
    * when the input string is either empty or null.
    * */
    @Test
    public void test_isEmptyOrNullString() throws Exception {
        // Given
        String emptyString = "";
        String nullString = null;
        // Then
        assertThat(emptyString, isEmptyOrNullString());
        assertThat(nullString, isEmptyOrNullString());
    }

    
    /*
    * isEmptyString(): Matcher which matches when the input string is empty.
    * */
    @Test
    public void test_isEmptyString() throws Exception {
        // Given
        String emptyString = "";
        // Then
        assertThat(emptyString, isEmptyString());
    }



    /*
    * isIn(): Matcher which matches when the input item 
    * is found within the given Collection or Array.
    * */
    @Test
    public void test_isIn() throws Exception {
        // Given
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(6);
        set.add(4);
        // Then
        assertThat(4, isIn(set));
    }


    /*
    * isOneOf(): Matcher which matches when the 
    * input object is one of the given objects.
    * */
    @Test
    public void test_isOneOf() throws Exception {
        // Then
        assertThat(4, isOneOf(3, 4, 5));
    }

    /*
    * iterableWithSize(): Matchers which match when the input Iterable 
    * has the specified size, or matches the specified size matcher.
    * */
    // Actual Value
    @Test
    public void test_iterableWithSize() throws Exception {
        // Given
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(6);
        set.add(4);
        // Then
        assertThat(set, iterableWithSize(3));
    }

    // Matcher
    @Test
    public void test_iterableWithSize_matcher() throws Exception {
        // Given
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(6);
        set.add(4);
        // Then
        assertThat(set, iterableWithSize(lessThan(4)));
    }

    /*
    * lessThan(): Matcher which matches Comparable objects where the 
    * input object is less than the specified value, using the compareTo 
    * method.
    * */
    @Test
    public void test_lessThan() throws Exception {
        // Then
        assertThat("apple", lessThan("zoo"));
    }


    /*
    * lessThanOrEqualTo(): Matcher which matches Comparable objects 
    * where the input object is less than or equal to the specified 
    * value, using the compareTo method.
    * */
    @Test
    public void test_lessThanOrEqualTo() throws Exception {
        // Then
        assertThat(2, lessThanOrEqualTo(2));
    }


    /*
    * not(): Matcher which wraps an existing 
    * matcher and inverts it’s matching logic
    * */
    @Test
    public void test_not_matcher() throws Exception {
        // Then
        assertThat("zoo", not(lessThan("apple")));
    }

    // Also an alias for not(equalTo(...)) when used with a value instead of a matcher
    @Test
    public void test_not_value() throws Exception {
        // Then
        assertThat("apple", not("orange"));
    }


    /*
    * notNullValue(): Matcher which matches 
    * when the input value is not null.
    * */
    @Test
    public void test_notNullValue() throws Exception {
        // Then
        assertThat("apple", notNullValue());
    }


    /*
    * nullValue(): Matcher which matches when the input value is null.
    * */
    @Test
    public void test_nullValue() throws Exception {
        // Given
        Object nothing = null;
        // Then
        assertThat(nothing, nullValue());
    }


    /*
    * sameInstance(): Matcher which matches when the input 
    * object is the same instance as the specified value.
    * */
    @Test
    public void test_sameInstance() throws Exception {
        // Given
        Object one = new Object();
        Object two = one;
        // Then
        assertThat(one, sameInstance(two));
    }



    /*
    * samePropertyValuesAs(): Matchet which matches when the input Bean has the same property
    * values as the specified Bean, i.e. if there are properties on the Bean under test they
    * must exist, and have the same values as the bean being specified in the test condition.
    * */
    // Given the following Java class:
    private class Bean {
        private Integer number;
        private String text;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    // We can write the following test:
    @Test
    public void test_samePropertyValuesAs() throws Exception {
        // Given
        Bean one = new Bean();
        one.setText("text");
        one.setNumber(3);
        Bean two = new Bean();
        two.setText("text");
        two.setNumber(3);
        // Then
        assertThat(one, samePropertyValuesAs(two));
    }


    /*
    * startsWith(): Matcher which matches if the
    * input string starts with the given prefix.
    * */
    @Test
    public void test_startsWith() throws Exception {
        // Given
        String test = "Beginnings are important!";
        // Then
        assertThat(test, startsWith("Beginning"));
    }


    /*
    * stringContainsInOrder(): Matcher which matches if the input String contains the
    * substrings in the given Iterable, in the order in which they are returned from
    * the Iterable.
    * */
    @Test
    public void test_stringContainsInOrder() throws Exception {
        // Given
        String test = "Rule number one: two's company, but three's a crowd!";
        // Then
        assertThat(test, stringContainsInOrder(Arrays.asList("one", "two", "three")));
    }



    /*
    * theInstance(): Matcher which matches when the input object is the same
    * instance as the specified value. Behaves the same as ‘sameInstance()’
    * */
    @Test
    public void test_theInstance() throws Exception {
        // Given
        Object one = new Object();
        Object two = one;
        // Then
        assertThat(one, theInstance(two));
    }



    /*
    * typeCompatibleWith(): Matcher which matches when objects of the 
    * input Type can be assigned to references of the specified base Type.
    * */
    @Test
    public void test_typeCompatibleWith() throws Exception {
        // Given
        Integer integer = 3;
        // Then
        assertThat(integer.getClass(), typeCompatibleWith(Number.class));
    }

    // .2. Simple Matchers Combining Other Matchers
    // The following matchers primarily work to combine other matchers.



    /*
    * allOf(): Matcher which matches when all of the input Matchers match, behaves 
    * like a Logical AND. Can take individual Matchers or an Iterable of Matchers.
    * */
    // Individual Matchers
    @Test
    public void test_allOf_individual() throws Exception {
        // Given
        String test = "starting off well, gives content meaning, in the end";
        // Then
        assertThat(test, allOf(startsWith("start"), containsString("content"), endsWith("end")));
    }

    // Iterable of Matchers
    @Test
    public void test_allOf_iterable() throws Exception {
        // Given
        String test = "Hello, world!";
        List<Matcher<? super String>> matchers = Arrays.asList(containsString("world"), startsWith("Hello"));
        // Then
        assertThat(test, allOf(matchers));
    }


    /*
    * anyOf(): Matcher which matches when any of the input Matchers match, behaves like a Logical OR. Can take individual Matchers or an Iterable of Matchers.
    * */
    // Individual Matchers
    @Test
    public void test_anyOf_individual() throws Exception {
        // Given
        String test = "Some things are present, some things are not!";
        // Then
        assertThat(test, anyOf(containsString("present"), containsString("missing")));
    }

    // Iterable of Matchers
    @Test
    public void test_anyOf_iterable() throws Exception {
        // Given
        String test = "Hello, world!";
        List<Matcher<? super String>> matchers = Arrays.asList(containsString("Hello"), containsString("Earth"));
        // Then
        assertThat(test, anyOf(matchers));
    }



    /*
    * array(): Matcher which matches when the elements of an input array
    * individually match using the specified Matchers, in order. The number
    * of Matchers must be equal to the size of the array.
    * */
    @Test
    public void test_array() throws Exception {
        // Given
        String[] test = {"To be", "or not to be", "that is the question!"};
        // Then
        assertThat(test, array(startsWith("To"), containsString("not"), instanceOf(String.class)));
    }



    /*
    * both(): Matcher which, when used in combination with it’s
    * combinable matcher .and() will match when both specified
    * matchers match.
    * */
    @Test
    public void test_both() throws Exception {
        // Given
        String test = "Hello, world!";
        // Then
        assertThat(test, both(startsWith("Hello")).and(endsWith("world!")));
    }



    /*
    * either(): Matcher which, when used in combination with it’s combinable
    * matcher .or() will match when either if the specified matchers match.
    * */
    @Test
    public void test_either() throws Exception {
        // Given
        String test = "Hello, world!";
        // Then
        assertThat(test, either(startsWith("Hello")).or(endsWith("universe!")));
    }



    /*
    * is(): Matcher which matches when it’s input matcher matches, used
    * simply for convenience and to make assertions read more like English.
    * */
    @Test
    public void test_is_matcher() throws Exception {
        // Given
        Integer test = 5;
        // Then
        assertThat(test, is(greaterThan(3)));
    }

    // Also used as an alias for is(equalTo(...)), similar to not(...) and not(equalTo(...))
    @Test
    public void test_is_value() throws Exception {
        // Given
        Integer test = 5;
        // Then
        assertThat(test, is(5));
    }



    /*
    * describedAs(): Matcher which is used to override the failure output of another matcher.
    * Used when a custom failure output is needed. Arguments are the failure message, the
    * original Matcher and then any values which will be formatted into the failure message
    * using placeholders %0, %1, %2…
    * */
    @Test
    public void test_describedAs() throws Exception {
        // Given
        Integer actual = 7;
        Integer expected = 10;
        // Then
        assertThat(actual, describedAs("input > %0", greaterThan(expected), expected));
    }
}