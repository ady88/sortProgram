package com.algorithms.sortprogram;

import com.algorithms.sortprogram.services.AbstractSortService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    private static final String INCORRECT_SORT_MESSAGE = "The %s is incorrectly implemented.";
    private static final String SUCCESS_SORT_MESSAGE = "The %s has finished succesfully.";
    private static final String INITIAL_ARRAY_MESSAGE = "The initial array of unordered elements is:\n  %s";
    private static final String ORDERED_ARRAY_MESSAGE = "The sorted array is:\n  %s";
    private static final int NUMBER_OF_VALUES = 100;
    private static final int NUMBER_MIN_BOUND = 0;
    private static final int NUMBER_MAX_BOUND = 10000;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();

        AbstractSortService<Integer> sortIntegerService = injector.getInstance(AbstractSortService.class);

        Random random = new Random();
        Integer[] array = random.ints(NUMBER_OF_VALUES, NUMBER_MIN_BOUND, NUMBER_MAX_BOUND).boxed().toArray(Integer[]::new);

        LOG.info(String.format(INITIAL_ARRAY_MESSAGE, Arrays.toString(array)));
        final BiPredicate<Integer, Integer> comparator = (first, second) -> first.compareTo(second) > 0;

        SortStatistics statistics = sortIntegerService.sort(array, comparator);

        if (sortIntegerService.isSorted(array, comparator) == false) {
            LOG.severe(String.format(INCORRECT_SORT_MESSAGE, statistics.getAlgorithmName()));
        } else {
            LOG.info(String.format(SUCCESS_SORT_MESSAGE, statistics.getAlgorithmName()));
            LOG.info(String.format(ORDERED_ARRAY_MESSAGE, Arrays.toString(array)));
        }
    }
}
