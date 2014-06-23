import java.io.BufferedReader;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

public class GetErTag {

	String[] posTag = new String[100];

	DecisionTrie d1 = new DecisionTrie();

	Boolean reachedLeaf = true;

	Node n = d1.rootNode;
	
	String[] engWords = new String[30];
	String[] erOfWord = new String[30];

	public void getErTagWithFreq(String eng, String pos) {

		posTag = pos.split(",");

		for (int i = 0; i < posTag.length; i++) {

			// Trace the Trie till node contains pos tag
			if (n.edges.containsKey(posTag[i])) {
			

				n = n.edges.get(posTag[i]);

			} else // tags not found in trie
			{
				System.out.println("\nTRIE DOESNT CONTAIN " + posTag[i]);

				JOptionPane.showMessageDialog(null,
						"YOU HAVE A SMALL TRAINING DATA", "ALERT",
						JOptionPane.ERROR_MESSAGE);

				System.out.println("NOT PRESENT IS  " + eng);
				reachedLeaf = false;

				break;

			}
		}

		if (reachedLeaf) {

			System.out.println("ER TAGGING  WITH CORRESPONDING FREQUENCY IS  ");

			System.out.println(n.erTagLeaf);

			Set<String> ERs = n.erTagLeaf.keySet();

			Iterator i = ERs.iterator();

			while (i.hasNext()) {
				System.out.println("------------------------------------");
				String er = (String) i.next();

				er = er.replace("[", ""); // remove brackets from list
				er = er.replace("]", "");

				erOfWord = er.split(",");
				engWords = eng.split(",");
				int c = -1;
				for (String s5 : erOfWord) {
					c++;
					if (!(s5.equals(" "))) {

						if (c != 0)
							System.out.println("%%% " + engWords[c] + "   "
									+ s5);

					}
				}

				System.out.println("------------------------------------");
			}
			reachedLeaf = false;
		}
	}

}
