package com.chris.algorithm.demo.leetcode.problem_20;

import java.util.Stack;

/**
 * Created by ye830 on 10/17/2020.
 * <p>
 * Description:
 * Leetcode 20
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1 - Open brackets must be closed by the same type of brackets.
 * 2 - Open brackets must be closed in the correct order.
 *
 * @author Chris Ye
 */
public class ValidParentheses {
    public static void main(String[] args) {
//        String parentheses = "[{()}]";
//        String parentheses = "[{()}";
        String parentheses = "}";
        System.out.println(isValid(parentheses));

    }

//    private static boolean isValid(String parenthesesStr) {
//        ArrayStack<Character> myStack = new ArrayStack<>();
//        for (char myChar : parenthesesStr.toCharArray()) {
//            if (myChar == '[' || myChar == '{' || myChar == '(') {
//                myStack.push(myChar);
//            }
//
//            if (myChar == ')') {
//                char res = myStack.pop();
//                if (res != '(') {
//                    return false;
//                }
//            }
//
//            if (myChar == ']') {
//                char res = myStack.pop();
//                if (res != '[') {
//                    return false;
//                }
//            }
//
//            if (myChar == '}') {
//                char res = myStack.pop();
//                if (res != '{') {
//                    return false;
//                }
//            }
//        }
//        if (myStack.getSize() != 0) {
//            return false;
//        }
//        return true;
//    }

    private static boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for (char myChar : s.toCharArray()) {
            if (myChar == '[' || myChar == '{' || myChar == '(') {
                myStack.push(myChar);
            } else {
                if (myStack.isEmpty()){
                    return false;
                }
                char res = myStack.pop();
                if (myChar == ')' && res!='(') {
                    return false;
                }
                if (myChar == ']' && res!='[') {
                    return false;
                }
                if (myChar == '}' && res!='{') {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

}
