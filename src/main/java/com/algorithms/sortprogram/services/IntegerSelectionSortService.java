package com.algorithms.sortprogram.services;

import java.util.function.BiPredicate;

public class IntegerSelectionSortService extends AbstractSortService<Integer> {

    private static final String ALGORITHM_NAME = "selection sort";

    @Override
    protected void actualSort(Integer[] array, final BiPredicate<Integer, Integer> comparator) {
	int arraySize = array.length;

	for (int i = 0; i < arraySize; i++) {
	    for (int j = i + 1; j < arraySize; j++) {
		if (comparator.test(array[j], array[i])) {
		    exchange(array, i, j);
		}
	    }
	}
    }

    @Override
    protected String getAlgorithmName() {
	return ALGORITHM_NAME;
    }
}
