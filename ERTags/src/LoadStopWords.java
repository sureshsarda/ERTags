import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoadStopWords {
	
	String[] arr = new String[1000];
	static Boolean b2 = true;

	static public List<String> stopWord = new ArrayList<String>();
	

	public LoadStopWords() throws IOException {
		String s;
		FileReader fr = new FileReader("D:\\Workplace\\Eclipse Workspace\\ERTags\\stopWords.csv");
		BufferedReader br = new BufferedReader(fr);

		// Storing list of Stop Words from file in array
		while ((s = br.readLine()) != null) {
			arr = s.split(",");

			for (int i = 0; i < arr.length; i++) {
				arr[i] = arr[i].trim();

				stopWord.add(arr[i]);
			}

		}

	}

}
