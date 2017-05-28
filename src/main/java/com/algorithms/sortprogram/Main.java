package com.algorithms.sortprogram;

import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author ady88
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private static final String INCORRECT_SORT_MESSAGE = "The %s is incorrectly implemented.";
    private static final String SUCCESS_SORT_MESSAGE = "The %s has finished succesfully.";

    private static final int NUMBER_OF_VALUES = 100000;
    private static final int NUMBER_MIN_BOUND = 0;
    private static final int NUMBER_MAX_BOUND = 10000;

    public static void main(String[] args) {
	Random random = new Random();

	Integer[] array = random.ints(NUMBER_OF_VALUES, NUMBER_MIN_BOUND, NUMBER_MAX_BOUND).boxed().toArray(Integer[]::new);

	// AbstractSortService<Integer> sortIntegerService = new IntegerSelectionSortService(array);
	AbstractSortService<Integer> sortIntegerService = new IntegerInsertionSortService(array);

	SortStatistics statistics = sortIntegerService.sort();

	if (sortIntegerService.isSorted() == false) {
	    LOG.severe(String.format(INCORRECT_SORT_MESSAGE, statistics.getAlgorithmName()));
	} else {
	    LOG.info(String.format(SUCCESS_SORT_MESSAGE, statistics.getAlgorithmName()));
	}
    }

}