package hashtable;

public class HashTableLinearProbing {
	private class Entry {

		int key;
		String value;

		public Entry(int k, String v) {
			key = k;
			value = v;
		}
	}

	private Entry[] entries = new Entry[5];
	private int count = 0;

	public void put(int key, String value) {
		var entry = getEntry(key);
		if (entry != null) {
			entry.value = value;
			return;
		}

		if (isFull())
			throw new IllegalStateException();

		entries[getIndex(key)] = new Entry(key, value);
		count++;
	}

	public String get(int key) {
		var entry = getEntry(key);
		return entry != null ? entry.value : null;
	}

	public void remove(int key) {
		int index = getIndex(key);

		if (index == -1 || entries[index] == null)
			return;

		entries[index] = null;
		count--;
	}

	public int size() {
		return count;
	}

	private Entry getEntry(int key) {
		var index = getIndex(key);
		return index >= 0 ? entries[index] : null;
	}

	private int getIndex(int key) {
		int steps = 0;
		while (steps < entries.length) {
			int index = index(key, steps++);
			var entry = entries[index];
			if (entry == null || entry.key == key)
				return index;
		}
		return -1;
	}

	private int hash(int key) {
		return key % entries.length;
	}

	private int index(int key, int i) {
		return (hash(key) + i) % entries.length;
	}

	private boolean isFull() {
		return count == entries.length;
	}
}
