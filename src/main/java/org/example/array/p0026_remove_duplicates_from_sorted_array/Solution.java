package org.example.array.p0026_remove_duplicates_from_sorted_array;

/**
 * Удалить дубликаты на месте так, чтобы каждый
 * уникальный элемент встречался только один раз.
 * Используем 2 указателя
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) { //пограничные условия
            return n;
        }

        int uniqueIndex = 0; // отслеживает последний уникальный элемент
        int currentIndex = 1; // сканирует массив


        while (currentIndex < n) {
            // если найден новый уникальный элемент - сдвигаем его вперед
            if (nums[uniqueIndex] != nums[currentIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[currentIndex];
            }
            currentIndex++;
        }
        return uniqueIndex + 1;
    }
}