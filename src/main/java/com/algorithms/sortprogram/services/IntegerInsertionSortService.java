package com.algorithms.sortprogram.services;

import java.util.function.BiPredicate;

public class IntegerInsertionSortService extends AbstractSortService<Integer> {

    private static final String ALGORITHM_NAME = "insertion sort";

    @Override
    protected void actualSort(Integer[] array, final BiPredicate<Integer, Integer> comparator) {
        int arraySize = array.length;

        for (int i = 1; i < arraySize; i++) {
            int j = i;
            int elementToMove = array[i];
            while (j > 0 && comparator.test(elementToMove, array[j - 1])) {
                array[j] = array[j - 1];
                j = j - 1;
            }

            if (i != j) {
                array[j] = elementToMove;
            }
        }
    }

    @Override
    protected String getAlgorithmName() {
        return ALGORITHM_NAME;
    }
}
