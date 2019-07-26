package cn.likegirl.lintcode.带最小值操作的栈;

/**
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 * <p>
 * 注意事项：
 * 如果堆栈中没有数字则不能进行min方法的调用
 * <p>
 * 样例
 * 如下操作：
 * push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
 *
 * @author LikeGirl
 */
public class MinStack {
    private final static Integer DEFAULT_LENGTH = 5;
    private final static Integer DEFAULT_DILATATION_LENGTH = 10;
    private int top;
    private Integer[] stacks;
    private Integer[] minStacks;

    public MinStack() {
        // do intialization if necessary
        top = -1;
        stacks = new Integer[DEFAULT_LENGTH];
        minStacks = new Integer[DEFAULT_LENGTH];
    }

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        int len = stacks.length - 1;
        if (top == len) {
            Integer[] tempStacks = stacks.clone();
            Integer[] tempMinStacks = minStacks.clone();
            stacks = new Integer[len + DEFAULT_DILATATION_LENGTH];
            minStacks = new Integer[len + DEFAULT_DILATATION_LENGTH];
            System.arraycopy(tempStacks, 0, stacks, 0, top + 1);
            System.arraycopy(tempMinStacks, 0, minStacks, 0, top + 1);
        }
        if (top == -1) {
            minStacks[top + 1] = number;
        } else {
            minStacks[top + 1] = number < minStacks[top] ? number : minStacks[top];
        }
        stacks[++top] = number;
    }

    /**
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (top == -1) {
            throw new RuntimeException();
        }
        return stacks[top--];
    }

    /**
     * @return: An integer
     */
    public int min() {
        // write your code here
        if (top == -1) {
            throw new RuntimeException();
        }
        return minStacks[top];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        /*minStack.push(1);
        System.out.println(minStack.pop());
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.min();
        minStack.push(1);
        System.out.println(minStack.min());*/
        minStack.push(5);
        minStack.push(5);
        minStack.push(4);
        minStack.push(4);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(3);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        minStack.push(2);
        minStack.push(2);
        minStack.push(1);
        minStack.push(1);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        minStack.min();
        minStack.pop();
        minStack.min();
        minStack.pop();
    }


}
