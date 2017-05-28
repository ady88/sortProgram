package com.algorithms.sortprogram;

public class IntegerSelectionSortService extends AbstractSortService<Integer> {

    private static final String ALGORITHM_NAME = "selection sort";

    public IntegerSelectionSortService(Integer[] array) {
	super(array);
    }

    @Override
    protected void actualSort() {
	int arraySize = array.length;

	for (int i = 0; i < arraySize; i++) {
	    for (int j = i + 1; j < arraySize; j++) {
		if (lessThan(array[j], array[i])) {
		    exchange(i, j);
		}
	    }
	}
    }

    @Override
    protected String getAlgorithmName() {
	return ALGORITHM_NAME;
    }

}
