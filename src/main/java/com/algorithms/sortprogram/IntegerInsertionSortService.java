package com.algorithms.sortprogram;

public class IntegerInsertionSortService extends AbstractSortService<Integer> {

    private static final String ALGORITHM_NAME = "insertion sort";

    public IntegerInsertionSortService(Integer[] array) {
	super(array);
    }

    @Override
    protected void actualSort() {
	int arraySize = array.length;

	for (int i = 1; i < arraySize; i++) {
	    for (int j = i; j > 0 && lessThan(array[j], array[j - 1]); j--) {
		exchange(j, j - 1);
	    }
	}
    }

    @Override
    protected String getAlgorithmName() {
	return ALGORITHM_NAME;
    }

}
