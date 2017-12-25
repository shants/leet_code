import java.util.LinkedList;

/**
 * Created by shantanus on 12/24/2017.
 */
class MyStack {

    LinkedList<Integer> l ;
    /** Initialize your data structure here. */
    public MyStack() {
        l = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        l.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return l.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return l.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return l.isEmpty();
    }
}
