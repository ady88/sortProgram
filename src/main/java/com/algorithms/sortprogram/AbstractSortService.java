package com.algorithms.sortprogram;

import com.google.inject.ProvidedBy;
import java.util.logging.Logger;

@ProvidedBy(SortServiceProvider.class)
public abstract class AbstractSortService<T extends Comparable> {

    private static final Logger LOG = Logger.getLogger(AbstractSortService.class.getName());
    private static final String START_SORT_MESSAGE = "Started %s";
    private static final String END_SORT_MESSAGE = "The %s has finished in %d miliseconds.";

    protected int numberOfExchanges = 0;

    public SortStatistics sort(final T[] array) {
	if (array == null) {
	    return null;
	}
	LOG.info(String.format(START_SORT_MESSAGE, getAlgorithmName()));
	long start = System.currentTimeMillis();

	// calling the actual sorting method
	actualSort(array);

	long duration = System.currentTimeMillis() - start;
	LOG.info(String.format(END_SORT_MESSAGE, getAlgorithmName(), duration));
	SortStatistics statistics = new SortStatistics();
	statistics.setAlgorithmName(getAlgorithmName());
	statistics.setDuration(duration);

	return statistics;
    }

    public boolean isSorted(final T[] array) {
	boolean result = true;

	for (int i = 0; i < array.length - 1; i++) {
	    if (lessThan(array[i + 1], array[i])) {
		result = false;
		break;
	    }
	}

	return result;
    }

    protected abstract void actualSort(final T[] array);

    protected abstract String getAlgorithmName();

    protected void exchange(final T[] array, final int first, final int second) {
	T auxiliar = array[first];
	array[first] = array[second];
	array[second] = auxiliar;
    }

    protected boolean lessThan(final T first, final T second) {
	return first.compareTo(second) < 0;
    }
}
