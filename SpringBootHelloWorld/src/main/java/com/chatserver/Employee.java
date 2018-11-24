package com.chatserver;
import java.util.ArrayList;
import java.util.List;
final public class Employee {
final static List<String> list = new ArrayList<>();
public static void main(String[] args) {
 list.add("Element 1");
 list.add("Element 2");
 list.add("Element 3");
 System.out.println(list);
}
}