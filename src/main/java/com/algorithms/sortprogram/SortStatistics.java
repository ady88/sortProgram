package com.algorithms.sortprogram;

public class SortStatistics {

    private String algorithmName;
    private String numberOfExchanges;
    private long duration;
    private int arraySize;

    public String getAlgorithmName() {
	return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
	this.algorithmName = algorithmName;
    }

    public String getNumberOfExchanges() {
	return numberOfExchanges;
    }

    public void setNumberOfExchanges(String numberOfExchanges) {
	this.numberOfExchanges = numberOfExchanges;
    }

    public long getDuration() {
	return duration;
    }

    public void setDuration(long duration) {
	this.duration = duration;
    }

    public int getArraySize() {
	return arraySize;
    }

    public void setArraySize(int arraySize) {
	this.arraySize = arraySize;
    }

    @Override
    public String toString() {
	return "SortStatistics{" + "algorithmName=" + algorithmName + ", numberOfExchanges="
		+ numberOfExchanges + ", duration=" + duration + ", arraySize=" + arraySize + '}';
    }

}
