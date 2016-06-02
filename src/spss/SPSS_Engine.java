package spss;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import spss.engine.Dictionary;
import spss.engine.IndexInfo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Saeid Dadkhah on 2016-03-10 5:30 PM.
 * Project: SPSS
 */

public class SPSS_Engine {

	public static final int MODE_LUCENE = 0;
	public static final int MODE_INDEX = 1;
	public static final int MODE_SEARCH = 2;

	public static final int F_TYPE_UNKNOWN = -1;
	public static final int F_TYPE_TOKENIZE = 0;
	public static final int F_TYPE_NOT_TOKENIZE = 1;

	private static final int HITS = 10;

	private int mode;

	// Lucene mode variables;
	private Directory directory;
	private Analyzer analyzer;
	private IndexWriter iw;
	private IndexSearcher is;

	// Index and search mode variables;
	private Dictionary dictionary;
	private ArrayList<ArrayList<IndexInfo>> index;
	private ArrayList<ArrayList<IndexInfo>> invertedIndex;

	public static void main(String[] args) {
		int check = MODE_INDEX;
		if (check == MODE_LUCENE) {
			System.out.println("===========((spss.SPSS_Engine Lucene mode test))===========");
			SPSS_Engine spssEngine = new SPSS_Engine(MODE_LUCENE);

			System.out.println("===========((Adding 1st doc))===========");
			ArrayList<String> fields = new ArrayList<>();
			ArrayList<String> values = new ArrayList<>();
			ArrayList<Integer> types = new ArrayList<>();
			fields.add("type");
			values.add("jpg");
			types.add(F_TYPE_NOT_TOKENIZE);
			fields.add("writer");
			values.add("saeid");
			types.add(F_TYPE_NOT_TOKENIZE);
			fields.add("body");
			values.add("go world");
			types.add(F_TYPE_TOKENIZE);
			try {
				spssEngine.addDoc(fields, values, types);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("===========((Adding 2nd doc))===========");
			fields.clear();
			values.clear();
			types.clear();
			fields.add("type");
			values.add("jpg");
			types.add(F_TYPE_NOT_TOKENIZE);
			fields.add("Writer");
			values.add("Mostafa");
			types.add(F_TYPE_NOT_TOKENIZE);
			fields.add("body");
			values.add("bye world");
			types.add(F_TYPE_NOT_TOKENIZE);
			fields.add("pm");
			values.add("kalle zard");
			types.add(F_TYPE_NOT_TOKENIZE);
			try {
				spssEngine.addDoc(fields, values, types);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("===========((Finishing Indexing))===========");
			spssEngine.finishIndexing();

			System.out.println("===========((Start Searching))===========");
			try {
				SPSS_Engine.showRes(spssEngine.search("going"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (check == MODE_INDEX) {
			System.out.println("===========((spss.SPSS_Engine Lucene mode test))===========");
			SPSS_Engine spssEngine = new SPSS_Engine(MODE_INDEX);

			System.out.println("===========((Adding 1st doc))===========");
			try {
				spssEngine.addDoc("hello! my name is saeid! :)", 1);
				spssEngine.addDoc("hi! his name is mostafa! :(", 1);
				spssEngine.addDoc("hello! his name is sajjad! :|", 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			spssEngine.dictionary.printAll();
			System.out.println();
			for (ArrayList<IndexInfo> iis : spssEngine.invertedIndex) {
				for (IndexInfo ii : iis)
					System.out.print(ii.getId() + ": " + ii.getNum() + ", ");
				System.out.println();
			}
		}
	}

	public SPSS_Engine(int mode) { // stem stop word
		this.mode = mode;
		switch (mode) {
			case MODE_LUCENE:
				luceneInit();
				break;
			case MODE_INDEX:
				indexInit();
				break;
			case MODE_SEARCH:
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	private void luceneInit() {
//        analyzer = new StandardAnalyzer();
		analyzer = new EnglishAnalyzer();
//        analyzer = new SnowballAnalyzer(Version.LUCENE_5_5_0, "SPA");
		directory = new RAMDirectory();
		IndexWriterConfig iwConfig = new IndexWriterConfig(analyzer);
		iw = null;
		try {
			iw = new IndexWriter(directory, iwConfig);
		} catch (IOException e) {
			e.printStackTrace();
		}
		is = null;
	}

	private void indexInit() {
		index = new ArrayList<>();

		invertedIndex = new ArrayList<>();
	}

	public boolean addDoc(ArrayList<String> fields, ArrayList<String> values, ArrayList<Integer> types)
			throws Exception {
		// Checking Arguments
		if (mode != MODE_LUCENE)
			throw new Exception("You are not currently in lucene mode.");
		if (!iw.isOpen())
			throw new Exception("Index Writer is not open.");
		if (fields.size() != values.size() || fields.size() != types.size())
			throw new Exception("Size Mismatch.");

		// Making Document
		Document d = new Document();
		for (int i = 0; i < fields.size(); i++)
			switch (types.get(i)) {
				case F_TYPE_NOT_TOKENIZE:
					d.add(new StringField(fields.get(i).toLowerCase(), values.get(i).toLowerCase(), Field.Store.YES));
					break;
				case F_TYPE_TOKENIZE:
					d.add(new TextField(fields.get(i).toLowerCase(), values.get(i).toLowerCase(), Field.Store.YES));
					break;
				case F_TYPE_UNKNOWN:
					System.out.println(fields.get(i));
					throw new Exception("Unknown Type: " + i);
//                    break;
				default:
					throw new Exception("Illegal Type: " + i);
			}

		// Adding Document
		try {
			iw.addDocument(d);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void addDoc(String doc, int docId) throws Exception {
		if (mode != MODE_INDEX)
			throw new Exception("You are not currently in index mode.");
		String delimiters = "\\s+|,\\s*|\\.\\s*";
		String[] words = doc.split(delimiters);
		addIndices(words, docId);
	}

	private void addIndices(String[] words, int docId) {
		ArrayList<IndexInfo> iis = new ArrayList<>();
		invertedIndex.add(iis);
		for (int i = 0; i < words.length; i++) {
			IndexInfo ii = dictionary.contains(words[i]);
			if (ii == null) {
				int newId = dictionary.g
				dictionary.add(words[i], );
				indexInDictionary = dictionary.size() - 1;
			}
			// Index


			// Inverted Index
			int indexInIIS = iis.indexOf(indexInDictionary);
			if (indexInIIS == -1) { // In legend, not in words
				iis.add(new IndexInfo(indexInDictionary, 1));
			} else { // In words
				iis.get(indexInIIS).increaseNum(1);
			}
		}
	}

	public void finishIndexing() {
		if (mode == MODE_LUCENE) {
			if (!iw.isOpen())
				return;
			try {
				iw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				is = new IndexSearcher(DirectoryReader.open(directory));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (mode == MODE_INDEX) {
			mode = MODE_SEARCH;
		}
	}

	public Document[] search(String query)
			throws Exception {
		query = query.toLowerCase();
		if (is == null)
			throw new Exception("Index Searcher is not open");
		Query q = null;
		try {
			query = query.replaceAll("and", "AND");
			query = query.replaceAll("and", "OR");
			q = new QueryParser("body", analyzer).parse(query);
			System.out.println(q);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Document[0];
		}
		ScoreDoc[] docs = is.search(q, HITS).scoreDocs;
		Document[] result = new Document[docs.length];
		for (int i = 0; i < docs.length; i++)
			result[i] = is.doc(docs[i].doc);
		return result;
	}

	public static void showRes(Document[] res) {
		System.out.println("hits: " + res.length);
		for (int i = 0; i < res.length; i++) {
			System.out.println("Res: " + (i + 1));
			for (int j = 0; j < res[i].getFields().size(); j++) {
				String field = res[i].getFields().get(j).name();
				System.out.println(field + ": " + res[i].get(field));
			}
			System.out.println();
		}
	}

}
