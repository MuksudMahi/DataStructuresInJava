package hashtable;

import java.util.LinkedList;

public class HashTable {

	private class Entry {
		int key;
		String value;

		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}

	LinkedList<Entry>[] entries = new LinkedList[5];

	public void put(int k, String v) {

		var entry = getEntry(k);
		if (entry != null) {
			entry.value = v;
			return;
		}

		getOrCreateBucket(k).add(new Entry(k, v));
//		int index = hash(k);
//		if (entries[index] == null)
//			entries[index] = new LinkedList<>();
//		var bucket = entries[index];
//		for (var entry : bucket) {
//			if (entry.key == k) {
//				entry.value = v;
//				return;
//			}
//		}
//
//		bucket.addLast(new Entry(k, v));
	}

	public String get(int k) {
		var entry = getEntry(k);
		return (entry == null) ? null : entry.value;
//		int index = hash(k);
//		var bucket = entries[index];
//
//		if (bucket != null) {
//			for (var entry : bucket) {
//				if(entry.key==k)
//					return entry.value;
//			}
//		}
//		return null;
	}

	public void remove(int k) {
		var entry = getEntry(k);
		if (entry == null)
			throw new IllegalStateException();
		getBucket(k).remove(entry);

//		int index = hash(k);
//		var bucket = entries[index];
//		if(bucket==null)
//			throw new IllegalStateException();
//		for(var entry : bucket)
//		{
//			if(entry.key==k) {
//				bucket.remove(entry);
//				return;
//			}
//		}
//		throw new IllegalStateException(); 
	}

	private int hash(int k) {
		return k % entries.length;
	}

	private Entry getEntry(int k) {
		var bucket = getBucket(k);
		if (bucket != null) {
			for (var entry : bucket) {
				if (entry.key == k)
					return entry;
			}
		}
		return null;
	}

	private LinkedList<Entry> getBucket(int k) {
		return entries[hash(k)];
	}

	private LinkedList<Entry> getOrCreateBucket(int k) {
		int index = hash(k);

		if (entries[index] == null)
			entries[index] = new LinkedList<>();

		return entries[index];
	}
}
