package exercises;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Stack;

public class MaxStack {

    private Stack<Pair<Integer, Integer>> stack = new Stack<>();

    public Integer pop() {
        Pair<Integer, Integer> top = stack.pop();
        if (top == null) {
            return null;
        } else {
            return top.getKey();
        }
    }

    public void push(Integer i) {
        if (i==null) {
            return;
        }

        Integer maxInt = max();
        if (maxInt == null || i > maxInt) {
            maxInt = i;
        }
        stack.push(new ImmutablePair<>(i, maxInt));
    }

    public Integer peek() {
        try {
            return stack.peek().getKey();
        }
        catch (java.util.EmptyStackException e) {
            return null;
        }
    }

    public Integer max() {
        try {
            return stack.peek().getValue();
        }
        catch (java.util.EmptyStackException e) {
            return null;
        }
    }
}
