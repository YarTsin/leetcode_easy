package org.example.string.p0020_valid_parentheses;

import java.util.Stack;

/**
 * Дана строка s, содержащая только символы '(', ')', '{', '}', '[' и ']'.
 * Необходимо определить, является ли строка валидной, если:
 * Открытые скобки должны быть закрыты скобками того же типа
 * Скобки должны закрываться в правильном порядке
 *
 * Подход к решению
 * Используем структуру данных стек (LIFO - last in, first out):
 * При встрече открывающей скобки - помещаем её в стек
 * При встрече закрывающей скобки:
 * - Если стек пуст - последовательность невалидна
 * - Извлекаем последнюю открывающую скобку из стека и проверяем соответствие
 * - В конце проверяем, что стек пуст (все скобки закрыты)
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') { // Открывающие скобки
                stack.push(c);
            }

            // Закрывающие скобки с проверкой соответствия:
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Любое несоответствие
            }
        }
        return stack.isEmpty(); // Все скобки должны быть закрыты
    }
}
/*
Альтернативная реализация (без Stack)
public boolean isValid(String s) {
    char[] stack = new char[s.length()];
    int ptr = 0;

    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack[ptr++] = c;
        } else {
            if (ptr == 0) return false;
            char last = stack[--ptr];
            if (!(last == '(' && c == ')' ||
                 last == '{' && c == '}' ||
                 last == '[' && c == ']')) {
                return false;
            }
        }
    }
    return ptr == 0;
}
 */