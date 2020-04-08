package com.mfcookie.stack;

import java.util.*;

public class LeetCode341 {
    public static void main(String[] args) {
        ArrayList<NestedInteger> objects = new ArrayList<>();
        objects.add(new IntegerNestedInteger(2));
        objects.add(new IntegerNestedInteger(3));
        List<NestedInteger> nestedList = Arrays.asList(new NestedInteger[]{new ListNestedInteger(objects), new IntegerNestedInteger(5), new ListNestedInteger(objects)});

        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 */
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class IntegerNestedInteger implements NestedInteger {

    Integer integer;

    public IntegerNestedInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return null;
    }
}

class ListNestedInteger implements NestedInteger {

    List<NestedInteger> integers;

    public ListNestedInteger(List<NestedInteger> integers) {
        this.integers = integers;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return integers;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }


    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger peek = stack.peek();
            if (peek.isInteger()) {
                return true;
            }
            NestedInteger pop = stack.pop();
            List<NestedInteger> list = pop.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }
}
