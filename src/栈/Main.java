package 栈;

import 链表.LinkedList;

import java.util.Random;

public class Main {

    private static double testStack(Stack<Integer> stack,int opCount)
    {
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ;i < opCount;i++)
        {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0;i < opCount; i++)
        {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//        for(int i = 0 ; i < 5 ; i++)
//        {
//            stack.push(i);
//            System.out.println(stack);
//        }
//        stack.pop();
//        System.out.println(stack);
//        System.out.println(stack.peek());
        int opCount = 1000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time = testStack(arrayStack,opCount);
        System.out.println("ArrayStack, time: "+time+"S");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time1 = testStack(linkedListStack,opCount);
        System.out.println("LinkedListStack, time: "+time1+"S");
    }
}
