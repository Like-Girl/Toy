package cn.likegirl.lintcode.实现栈;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    List<Integer> elementData = new LinkedList<Integer>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        elementData.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        elementData.remove(elementData.size() - 1);
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return elementData.get(elementData.size() - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return elementData.isEmpty();
    }
}