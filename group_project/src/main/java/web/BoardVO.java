package web;

import java.sql.Timestamp;

public class BoardVO {
	private int idx;
	private String id;
	private String title;
	private Timestamp rgstdate;
	private Timestamp mdfydate;
	private String context;
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getRgstdate() {
		return rgstdate;
	}
	public void setRgstdate(Timestamp rgstdate) {
		this.rgstdate = rgstdate;
	}
	public Timestamp getMdfydate() {
		return mdfydate;
	}
	public void setMdfydate(Timestamp mdfydate) {
		this.mdfydate = mdfydate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", id=" + id + ", title=" + title + ", rgstdate=" + rgstdate + ", mdfydate="
				+ mdfydate + ", context=" + context + "]";
	}
}
