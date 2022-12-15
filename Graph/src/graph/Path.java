package graph;

import java.util.ArrayList;
import java.util.List;

public class Path {
	private List<String> nodes = new ArrayList<>();
	private int distance;

	public void add(String node) {
		nodes.add(node);
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Path->" + nodes.toString() + " Distance->" + distance;
	}
}
