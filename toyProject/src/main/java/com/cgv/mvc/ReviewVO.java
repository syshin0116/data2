package com.cgv.mvc;

public class ReviewVO {

	private int rId;
	private String mId;
	private String mvId;
	private String rComment;
	private int rRating;
	private String mvImg;
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
	public String getMvId() {
		return mvId;
	}
	public void setMvId(String mvId) {
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
		return "rVO [rId=" + rId + ", mId=" + mId + ", mvId=" + mvId + ", rComment=" + rComment + ", rRating="
				+ rRating + ", mvImg=" + mvImg + "]";
	}
}
