package com.algorithms.sortprogram;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractSortService<T extends Comparable> {

    private static final Logger LOG = Logger.getLogger(AbstractSortService.class.getName());
    private static final String START_SORT_MESSAGE = "Started %s";
    private static final String END_SORT_MESSAGE = "The %s has finished in %d miliseconds.";

    protected T[] array;
    protected int numberOfExchanges = 0;

    public AbstractSortService(T[] array) {
	this.array = array;
    }

    public SortStatistics sort() {
	if (array == null) {
	    return null;
	}
	LOG.info(String.format(START_SORT_MESSAGE, getAlgorithmName()));
	long start = System.currentTimeMillis();

	// calling the actual sorting method
	actualSort();

	long duration = System.currentTimeMillis() - start;
	LOG.info(String.format(END_SORT_MESSAGE, getAlgorithmName(), duration));
	SortStatistics statistics = new SortStatistics();
	statistics.setAlgorithmName(getAlgorithmName());
	statistics.setDuration(duration);

	return statistics;

    }

    public boolean isSorted() {
	boolean result = true;

	for (int i = 0; i < array.length - 1; i++) {
	    if (lessThan(array[i + 1], array[i])) {
		result = false;
		break;
	    }
	}

	return result;
    }

    public String getArray() {
	return Arrays.toString(array);
    }

    protected abstract void actualSort();

    protected abstract String getAlgorithmName();

    protected void exchange(int first, int second) {
	T auxiliar = array[first];
	array[first] = array[second];
	array[second] = auxiliar;
    }

    protected boolean lessThan(final T first, final T second) {
	return first.compareTo(second) < 0;
    }
}
