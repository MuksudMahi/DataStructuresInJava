package sorting;

public class CountingSort {
	public void sort(int[] nums, int max) {
		int[] count=new int[max+1];
		for(var item:nums) {
			count[item]++;
		}
		
		var k=0;
		for(var i=0;i<count.length;i++)
			for(var j=0;j<count[i];j++)
				nums[k++]=i;
	}
}
