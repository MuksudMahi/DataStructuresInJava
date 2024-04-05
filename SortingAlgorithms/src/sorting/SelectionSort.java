package sorting;

public class SelectionSort {
	public void sort(int[] array) {
		for(var i=0;i<array.length;i++) {
			var minVal=array[i];
			for(var j=i;j<array.length;j++) {
				if(array[j]<minVal) {
					minVal=array[j];
					swap(i,j,array);
				}
			}
		}
	}
	
	private void swap(int i,int j, int[] array) {
		var temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
