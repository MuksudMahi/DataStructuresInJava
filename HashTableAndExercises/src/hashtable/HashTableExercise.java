package hashtable;

import java.util.*;

public class HashTableExercise {
	public int mostFrequent(int[] nums) {
		Map<Integer, Integer> h = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int res = -1;
		for (var num : nums) {
			var count = h.get(num);
			if (count == null) {
				h.put(num, 1);
			} else {
				h.put(num, ++count);
				if (max < count) {
					max = count;
					res = num;
				}
			}
		}
		return res;
	}

	public int countPairsWithDiff(int nums[], int k)
	{
        Set<Integer> h = new HashSet<>();
        int count =0;
        for(var num : nums)
        {
        	h.add(num);
        }
        for(var num : nums)
        {
        	if(h.contains(num+k))
        		count ++;
        	if(h.contains(num-k))
        		count ++;
        	h.remove(num);
        }
        return count;
    }
	
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        return null;
    }
}