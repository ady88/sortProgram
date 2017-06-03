package com.algorithms.sortprogram;

import com.algorithms.sortprogram.helpers.Configs;
import com.algorithms.sortprogram.helpers.SortAlgorithms;
import com.google.inject.Provider;

public class SortServiceProvider implements Provider<AbstractSortService> {

    @Override
    public AbstractSortService get() {
	AbstractSortService sortService = null;
	SortAlgorithms selectedSort = Configs.getSelectedSort();

	switch (selectedSort) {
	    case INSERTION_SORT:
		sortService = new IntegerInsertionSortService();
		break;
	    case SELECTION_SORT:
		sortService = new IntegerSelectionSortService();
		break;
	    case SHELL_SORT:
		sortService = new IntegerShellSortService();
		break;
	}

	return sortService;
    }

}
