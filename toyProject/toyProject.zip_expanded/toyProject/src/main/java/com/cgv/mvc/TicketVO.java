package com.cgv.mvc;

public class TicketVO {

	private int tId;
	private String mId;
	private int mvId;
	private String tTime;
	private String tSection;
	private int tSeat;
	
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
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
	public String gettTime() {
		return tTime;
	}
	public void settTime(String tTime) {
		this.tTime = tTime;
	}
	public String gettSection() {
		return tSection;
	}
	public void settSection(String tSection) {
		this.tSection = tSection;
	}
	public int gettSeat() {
		return tSeat;
	}
	public void settSeat(int tSeat) {
		this.tSeat = tSeat;
	}
	@Override
	public String toString() {
		return "TicketVO [tId=" + tId + ", mId=" + mId + ", mvId=" + mvId + ", tTime=" + tTime + ", tSection="
				+ tSection + ", tSeat=" + tSeat + "]";
	}
	
	
	
	
}
