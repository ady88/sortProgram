package com.algorithms.sortprogram;

public class IntegerShellSortService extends AbstractSortService<Integer> {

    private static final String ALGORITHM_NAME = "shell sort";

    @Override
    protected void actualSort(Integer[] array) {
        int arraySize = array.length;
        int step = 1;

        while (step < arraySize / 3) {
            step = 3 * step + 1;
        }

        while (step >= 1) {
            for (int i = step; i < arraySize; i = i + 1) {
                Integer elementToMove = array[i];
                int j = i;

                while (j - step >= 0 && lessThan(elementToMove, array[j - step])) {
                    array[j] = array[j - step];
                    j = j - step;
                }

                if (i != j) {
                    array[j] = elementToMove;
                }
            }

            step = step / 3;
        }
    }

    @Override
    protected String getAlgorithmName() {
        return ALGORITHM_NAME;
    }
}
