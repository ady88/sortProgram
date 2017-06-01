package com.algorithms.sortprogram;

public class IntegerInsertionSortService extends AbstractSortService<Integer> {

    private static final String ALGORITHM_NAME = "insertion sort";

    @Override
    protected void actualSort(Integer[] array) {
	int arraySize = array.length;

	for (int i = 1; i < arraySize; i++) {
	    int j = i;
	    int elementToMove = array[i];
	    while (j > 0 && lessThan(elementToMove, array[j - 1])) {
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
