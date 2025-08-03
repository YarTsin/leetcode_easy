package org.example.array.p0035_search_insert_position;

/**
 * Вернуть индекс, если значение найдено
 * или вернуть индекс где элемент должен был бы находиться
 * Используем бинарный поиск (Binary Search) (по условию)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0; // начало массива
        int right = nums.length - 1; // конец массива

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // нашли точное совпадение
            } else if (nums[mid] < target) {
                left = mid + 1;// ищем в правой половине
            } else {
                right = mid - 1; //ищем в левой половине
            }
        }
        return left; // если не нашли возвращаем позицию для вставки
    }
}