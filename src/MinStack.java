import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shantanus on 12/24/2017.
 */
class MinStack {
    private Stack<Integer> arr;
    private Stack<Integer> minArr;
    /** initialize your data structure here. */
    public MinStack() {
        arr = new Stack<>();
        minArr = new Stack<>();
    }

    public void push(int x) {
        arr.push(x);
        if(minArr.isEmpty()){
           minArr.push(x);
        }else if(minArr.peek() < x){
            minArr.push(minArr.peek());
        }else{
            minArr.push(x);
        }
    }

    public void pop() {
        if(!arr.isEmpty()){
            arr.pop();
            minArr.pop();
        }
    }

    public int top() {
      return arr.peek();
    }

    public int getMin() {
        return minArr.peek();
    }
}
