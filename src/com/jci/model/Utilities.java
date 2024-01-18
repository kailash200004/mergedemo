package com.jci.model;

import java.util.Arrays;

public class Utilities {
	public static int findIndex(String arr[], int t){
		int index = Arrays.binarySearch(arr, t);
		return (index < 0) ? -1 : index;
	}
}
