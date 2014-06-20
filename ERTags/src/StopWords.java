import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StopWords {
	static DecisionTrie decisionTrie = new DecisionTrie();

	public static void StopWordFilter(String sent, String posT, String erT)
			throws IOException {

		// Storing eng sent,POS tags and ER tags in the form of list

		List<String> engSentences = new ArrayList<String>(Arrays.asList(sent
				.split(",")));
		List<String> posTags = new ArrayList<String>(Arrays.asList(posT
				.split(",")));
		List<String> erTags = new ArrayList<String>(Arrays.asList(erT
				.split(",")));

		// Iterator over eng sentence to remove stop words
		Iterator<String> i = engSentences.iterator();

		int v = 0;
		while (i.hasNext()) {
			// must be called before you can call i.remove()
			String s1 = i.next();
			v++; // to calculate index to remove corresponding POS and ER tag
			for (String j : new LoadStopWords().stopWord) {
				// if it's a stop word AND it is not ER tagged
				if (s1.equals(j) && (erTags.get(v - 1).equals(""))) {
					i.remove(); // remove eng word
					System.out.println("Stopword removed is " + s1
							+ "  POS removed IS " + posTags.get(v - 1));
					v--;
				
					posTags.remove(v); // remove corresponding POS tag

					erTags.remove(v); // remove corresponding ER tag

					break;

				}

			}

		}

		Program p2 = new Program();
		p2.sentence = engSentences.toString();

		p2.posTag = posTags.toString();

		p2.erTag = erTags.toString();

		p2.posTag = p2.posTag.replace("[", ""); // remove brackets from list
		p2.posTag = p2.posTag.replace("]", "");

		System.out.println("now sequence becomes " + p2.posTag);

		// insert in trie one set

		decisionTrie.traversePath(p2.sentence, p2.posTag, p2.erTag);
		// decisionTrie.testData();

	}
}
