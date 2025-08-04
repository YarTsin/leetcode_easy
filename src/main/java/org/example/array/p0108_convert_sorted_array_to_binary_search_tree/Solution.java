package org.example.array.p0108_convert_sorted_array_to_binary_search_tree;

/**
 * Условие:
 * Дан отсортированный массив nums в возрастающем порядке.
 * Необходимо преобразовать его в сбалансированное по высоте бинарное
 * дерево поиска (BST).
 *
 * Сбалансированное по высоте дерево — это дерево, в котором
 * разница высот левого и правого поддеревьев любого узла не превышает 1.
 *
 * Оптимальное решение (Рекурсивный подход + бинарный поиск)
 * Середина массива — корень BST
 *
 * Как я понимаю в решении они подставляют класс TreeNode
 * в комментариях а мы меняем класс Solution на свой
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // Находим середину текущего подмассива
        int mid = left + (right - left) / 2;

        // Создаем корень из середины
        TreeNode root = new TreeNode(nums[mid]);

        // Рекурсивно строим левое и правое поддеревья
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}
/*
Пример
Пошаговый разбор на примере
Вход: nums = [-10, -3, 0, 5, 9]
Первый вызов (left=0, right=4) - индексы
mid = 0 + (4 - 0)/2 = 2 → корень = 0
Левое поддерево: [-10, -3]
Правое поддерево: [5, 9]
Левое поддерево (left=0, right=1) - индексы
mid = 0 + (1 - 0)/2 = 0 → корень = -10
Левое поддерево: [] (null)
Правое поддерево: [-3]
Правое поддерево (left=3, right=4):
mid = 3 + (4 - 3)/2 = 3 → корень = 5
Левое поддерево: [] (null)
Правое поддерево: [9]

      0
     / \
   -10  5
     \   \
     -3  9

 */