import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveTestDataStopWords {
	BufferedReader br;
	static String sentence;
	static String posTag;
	String s1;

	public RemoveTestDataStopWords(String s) throws IOException {

		FileReader fr = new FileReader(s);

		br = new BufferedReader(fr);

		// Read training data from Input file
		while ((s1 = br.readLine()) != null) {

			sentence = s1;
			posTag = br.readLine();

			System.out.println();
			// Filter stop words
			stopWordFilter(sentence, posTag);

		}

	}

	public static void stopWordFilter(String sent, String posT)
			throws IOException {

		// Storing eng sent,POS tags in the form of list

		List<String> engSentences = new ArrayList<String>(Arrays.asList(sent
				.split(",")));
		List<String> posTags = new ArrayList<String>(Arrays.asList(posT
				.split(",")));

		// Iterator over eng sentence to remove stop words
		Iterator<String> i = engSentences.iterator();

		int v = 0;
		while (i.hasNext()) {

			// must be called before you can call i.remove()
			String s1 = i.next();

			v++; // to calculate index to remove corresponding POS and ER tag

			for (String j : new LoadStopWords().stopWord) {

				// if it's a stop word

				if (s1.equals(j)) {

					i.remove(); // remove eng word

					System.out.println("Stopword removed is " + s1
							+ "  POS removed IS " + posTags.get(v - 1));

					posTags.remove(--v); // remove corresponding POS tag

					break;

				}

			}
		}

		sentence = engSentences.toString();

		posTag = posTags.toString();

		posTag = posTag.replace("[", ""); // remove brackets from list
		posTag = posTag.replace("]", "");

		sentence = sentence.replace("[", ""); // remove brackets from list
		sentence = sentence.replace("]", "");

		System.out.println("PROCESSED TEST SENTENCWE " + sentence);
		GetErTag e1 = new GetErTag();
		e1.getErTagWithFreq(sentence, posTag);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
