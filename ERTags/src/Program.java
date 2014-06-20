import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class Program {

	BufferedReader br;
	//"D:\Workplace\Eclipse Workspace\ERTags\TestData.csv"
	public static String inputFile = "D:\\Workplace\\Eclipse Workspace\\ERTags\\TrainingData.csv";

	public static String testData = "D:\\Workplace\\Eclipse Workspace\\ERTags\\TestData.csv";

	public String sentence, posTag, erTag; // from Input file

	public void readFile() throws Exception {

		String s;
		FileReader fr = new FileReader(inputFile);

		br = new BufferedReader(fr);

		// Read training data from Input file
		while ((s = br.readLine()) != null) {

			sentence = s;
			posTag = br.readLine();
			erTag = br.readLine();

			// Filter stop words
			StopWords stopWords = new StopWords();

			stopWords.StopWordFilter(sentence, posTag, erTag);

		}

	}

	public static void main(String[] args) throws Exception {

		Program p = new Program();
		new LoadStopWords(); // load stop words
		p.readFile(); // Training data

		// TEST DATA

		DecisionTrie dt = new DecisionTrie();

		System.out.println("****** TEST *****");
		new RemoveTestDataStopWords(testData);
	}
}
