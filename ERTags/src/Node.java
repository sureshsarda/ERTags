import java.util.HashMap;

import java.util.Map;

public class Node {

	// POS tag and next node
	Map<String, Node> edges = new HashMap<String, Node>();

	// ER sequence and corresponding frequency
	Map<String, Integer> erTagLeaf = new HashMap<String, Integer>();

	// Insert ER sequence and frequency in leaf node

	public void sequenceTerminate(Node n, String er) {

		if (n.erTagLeaf.containsKey(er)) {
			int f = n.erTagLeaf.get(er);
			n.erTagLeaf.put(er, ++f);

		} else
			n.erTagLeaf.put(er, 1);

		System.out.println("CORRESPONDING ER SEQUENCE IS " + n.erTagLeaf);
		System.out.println("");

	}

}
