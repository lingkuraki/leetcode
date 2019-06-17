package com.kuraki.algorithms;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.注意空字符串可被认为是有效字符串。
 */
public class ValidParenthese {

    /**
     * 官方标准答案
     */
    // 创建一个hash表
    private HashMap<Character, Character> mappings;

    // 对map进行初始化
    public ValidParenthese() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // 初始化一个stack，用于计算
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                // 如果不相等，说明并不是有效的字符串
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // 向栈中添加'('、'{'、'['
                stack.push(c);
            }
        }
        // 如果是有效的，此时必然是一个空栈，否则就是无效的。
        return stack.isEmpty();
    }
}
