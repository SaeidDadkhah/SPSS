package spss.engine;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Saeid Dadkhah on 2016-06-01 2:33 PM.
 * Project: SPSS
 */
public class Dictionary {

	private HashMap<String, IndexInfo> hMDic;

	public Dictionary() {
		hMDic = new HashMap<>();
	}

	public boolean add(String word, IndexInfo indexInfo) {
		if (!hMDic.containsValue(indexInfo)) {
			hMDic.put(word, indexInfo);
			return true;
		}
		return false;
	}

	public IndexInfo contains(String word) {
		return hMDic.get(word);
	}

	public int genNewId(){
		Random random = new Random();
	}

	public void printAll(){
		for(String key: hMDic.keySet())
			System.out.println(key + ": <" + hMDic.get(key) + ">");
	}

}
