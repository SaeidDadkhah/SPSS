package extra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Saeid Dadkhah on 2016-06-01 12:28 AM.
 * Project: SPSS
 */
public class SplitDocs {

	public static void main(String[] args) {
		int bufferSize = 256 * 1024;
		String docSplitter = "<مقاله>";
		char[] buffer = new char[bufferSize];
		ArrayList<String> docs = new ArrayList<>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(".\\files\\Phase.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			assert br != null;
			String doc = "";
			for (int i = 0; i < 3; i++) {
				br.read(buffer);
				doc += new String(buffer);
				String[] tmp = doc.split(docSplitter);
				for (int j = 0; j < tmp.length - 1; j++)
					docs.add(tmp[j].trim());
				doc = tmp[tmp.length - 1];
			}
			docs.add(doc);
			System.out.println(docs.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
