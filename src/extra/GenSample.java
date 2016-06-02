package extra;

import java.io.*;

/**
 * Created by Saeid Dadkhah on 2016-06-01 1:01 AM.
 * Project: SPSS
 */
public class GenSample {

	public static void main(String[] args) {
		int bufferSize = 256 * 1024;
		char[] buffer = new char[bufferSize];

		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\files\\Phase.txt"));
			String doc = "";
			for (int i = 0; i < 3; i++) {
				br.read(buffer);
				doc += new String(buffer);
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(".\\files\\Sample.txt"));
			bw.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
