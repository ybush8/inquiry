package com.bean;

public class Student {
	private String number;
	private String name;
	private String userClass;
	private String userSex;
	private String address;
	private String phone;
	
	public Student() {}
	
	public Student(String number,String name,String userClass,
			String userSex,String address,String phone) {
		this.name = name;
		this.number = number;
		this.userClass = userClass;
		this.userSex = userSex;
		this.phone = phone;
		this.address =address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}
	
	

}
