package com.ssafy.map.model;

public class GugunDto {
	int gugunCode;
	String gugunName;
	
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	@Override
	public String toString() {
		return "{\"code\":\"" + gugunCode + "\" , \"name\":\"" + gugunName+"\"}";
	}
}
