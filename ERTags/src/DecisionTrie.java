import java.security.KeyException;

public class DecisionTrie {

	static Node rootNode = new Node(); // Root node of Trie

	String[] posTag = new String[50];
	String erTag;
	Boolean notFound = false;

	static Boolean root = true;

	// Create trie and insert Post Tag and ER tag
	public void traversePath(String engSen, String posT, String erT) {
		erTag = erT;
		Node nextNode = new Node();
		nextNode = rootNode;
		posTag = posT.split(",");
		int index = 0;
		for (int i = 0; i < posTag.length; i++) {
			// Trace the Trie till node contains pos tag
			if (nextNode.edges.containsKey(posTag[i])) {
				System.out.println("IN TRIE ALREADY " + posTag[i]);
				nextNode = nextNode.edges.get(posTag[i]);
			}
			else // tags not found in trie
			{
				System.out.println("\nTRIE DOESN'T CONTAIN " + posTag[i]);

				index = i;
				notFound = true;
				break;
			}
		}

		System.out.println("");
		if (notFound) {
			// insert tags in the trie from that index
			System.out.println("INSERT SUBSEQUENT TAGS  ");
			for (int i = index; i < posTag.length; i++) {
				Node temp = new Node();

				if (nextNode == rootNode)

					System.out.println("before at RoOT " + i + "   "
							+ rootNode.edges);

				nextNode.edges.put(posTag[i], temp);
				System.out.println("INSERTED AT " + i + "   " + nextNode.edges);

				if (root) {
					rootNode = nextNode;

					root = false;
				}
				nextNode = temp;

			}

			// reset values
			notFound = false;
			index = 0;
		}

		// insert ER tag in leaf node
		nextNode.sequenceTerminate(nextNode, erTag);

	}

}
