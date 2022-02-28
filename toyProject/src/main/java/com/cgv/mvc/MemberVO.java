package com.cgv.mvc;

public class MemberVO {
	String mId;
	String mPw;
	String mEmail;
	String mPhone;
	@Override
	public String toString() {
		return "MemberVO [mId=" + mId + ", mPw=" + mPw + ", mEmail=" + mEmail + ", mPhone=" + mPhone + "]";
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

}
