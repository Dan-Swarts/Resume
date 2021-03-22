package csci2081.L8;

public class VehicleSorter {
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[5];

		vehicles[0] = new Car("ladsfkj",49);
		vehicles[1] = new Helicopter(" ",50.1);
		vehicles[2] = new Car(" ",20.5);
		vehicles[3] = new Boat(" ",4);
		vehicles[4] = new Boat(" ",400);

		sortVehicles(vehicles);

		for (int i = 0; i < vehicles.length; i++) {
			System.out.println(vehicles[i]);
		}
	}

	public static void sortVehicles(Vehicle[] vehicles) {
		quickSort(0,vehicles.length - 1,vehicles);
	}
		private static void swap(int index1, int index2, Vehicle[] vehicles){
			Vehicle temp;
			temp = vehicles[index1];
			vehicles[index1] = vehicles[index2];
			vehicles[index2] = temp;
		}

		private static int partition(int start, int end, Vehicle[] vehicles){
		Vehicle pivot = vehicles[start];
		int left = start;
		for(int i = start + 1; i < end; i++){
			if(vehicles[i].compareTo(pivot) > 0){
				swap(i,left,vehicles);
				left++;
			}
		}
		return left;
	}

	private static void quickSort(int start, int end, Vehicle[] vehicles){
		if(start < end){
			int pIndex = partition(start,end,vehicles);
			quickSort(start,pIndex - 1,vehicles);
			quickSort(pIndex + 1, end, vehicles);
		}
	}
}
