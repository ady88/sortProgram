package com.algorithms.sortprogram.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Configs {

    private static final Logger LOG = Logger.getLogger(Configs.class.getName());

    private static final String CANNOT_ACCESS_PROPERTIES_MESSAGE = "The properties file could not be accessed.";
    private static final String SELECTED_SORT_ALGORITHM_KEY = "defaultSortAlgorithm";
    private static final Properties PROPERTIES = new Properties();

    static {
	ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	
	try (InputStream inputStream = classloader.getResourceAsStream("settings.properties")) {
	    PROPERTIES.load(inputStream);
	} catch (IOException e) {
	    LOG.severe(CANNOT_ACCESS_PROPERTIES_MESSAGE);
	}
    }

    public static SortAlgorithms getSelectedSort() {
	String sortAlgorithm = PROPERTIES.getProperty(SELECTED_SORT_ALGORITHM_KEY);
	return SortAlgorithms.valueOf(sortAlgorithm);
    }
}
