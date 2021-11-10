package L9;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Insertion {
	public double[] InsertionSort(double[] dataArr, SearchInterface searchMeth) {
		ArrayList<Double> dataList = DoubleStream.of(dataArr).boxed().collect(Collectors.toCollection(ArrayList::new));
		
		Double tmpStore;
		int newIndex;
		
		for (int i = 0; i < dataList.size(); i++) {
			newIndex = searchMeth.findIndex(dataList, dataList.get(i), 0, i);
			tmpStore = dataList.get(i);
			dataList.remove(i);
			dataList.add(newIndex, tmpStore);
		}
		
		return Stream.of(dataList.toArray()).mapToDouble(Double::doubleValue).toArray();
	}
}
