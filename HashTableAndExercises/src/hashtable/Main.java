package hashtable;

public class Main {

	public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 5, 9, 2, 12, 3};
        HashTableLinearProbing e = new HashTableLinearProbing();
        e.put(10, "A");
        e.put(11, "C");
        e.put(20, "D");
        e.put(30, "D");

        
        System.out.println(e.size());
	}

}
