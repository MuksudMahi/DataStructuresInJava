package sorting;

import java.util.Arrays;

public class BubbleSort {
	public void sort(int[] array) {
		boolean  isSorted;
		for(var i=0;i<array.length;i++) {
			isSorted=true;
			for(var j=1;j<array.length-i;j++) {
				if(array[j]<array[j-1]) {
					swap(j,j-1, array);
					isSorted=false;
				}
			}
			if(isSorted)
				return;
		}
	}
	
	private void swap(int i,int j, int[] array) {
		var temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
