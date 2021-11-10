package L9;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Insertion {
	public Double[] InsertionSort(ArrayList<Double> dataList, SearchInterface searchMeth) {
		
		Double tmpStore;
		int newIndex;
		
		for (int i = 0; i < dataList.size(); i++) {
			newIndex = searchMeth.findIndex(dataList, dataList.get(i), 0, i);
			tmpStore = dataList.get(i);
			dataList.remove(i);
			dataList.add(newIndex, tmpStore);
		}
		
		return (Double[]) dataList.toArray();
	}
}
