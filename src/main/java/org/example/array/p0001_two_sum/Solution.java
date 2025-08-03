package org.example.array.p0001_two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Создаем мапу для хранения значения элемента и его индекса
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer requiredNum = target - numbers[i];
            if (map.containsKey(requiredNum)) {
                return new int[] {map.get(requiredNum), i};
            }
            map.put(numbers[i], i);
        }
        // По условию число должно быть но возврат для компиллятора
        return new int[] {-1, -1};
    }
}