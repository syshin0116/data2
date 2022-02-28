package com.cgv.mvc;

public class ReviewVO {
	private int rId;
	private String mId;
	private int mvId;
	private String rComment;
	private int rRating;
	private String mvImg;
	private double avg;
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getMvId() {
		return mvId;
	}
	public void setMvId(int mvId) {
		this.mvId = mvId;
	}
	public String getrComment() {
		return rComment;
	}
	public void setrComment(String rComment) {
		this.rComment = rComment;
	}
	public int getrRating() {
		return rRating;
	}
	public void setrRating(int rRating) {
		this.rRating = rRating;
	}
	public String getMvImg() {
		return mvImg;
	}
	public void setMvImg(String mvImg) {
		this.mvImg = mvImg;
	}
	@Override
	public String toString() {
		return "ReviewVO [rId=" + rId + ", mId=" + mId + ", mvId=" + mvId + ", rComment=" + rComment + ", rRating="
				+ rRating + ", mvImg=" + mvImg + "]";
	}
	
	
}
