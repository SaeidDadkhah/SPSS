package spss.engine;

/**
 * Created by Saeid Dadkhah on 2016-06-01 2:08 AM.
 * Project: SPSS
 */
public class IndexInfo {

	private int id;
	private int num;

	public IndexInfo(int id, int num) {
		this.id = id;
		this.num = num;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Integer)
			return id == (Integer) obj;
		return super.equals(obj);
	}

	public void increaseNum(int inc) {
		num += inc;
	}

	public int getId() {
		return id;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return id + " " + num;
	}
}
