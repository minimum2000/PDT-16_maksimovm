package com.example.tests;

public class ContactData {
	
	public String f_name;
	public String l_name;
	public String address;
	public String home_phone;
	public String mob_phone;
	public String wrk_phone;
	public String f_email;
	public String s_email;
	public String dd_birth;
	public String mm_birth;
	public String yyyy_birth;
	public String group_select;
	public String sec_address;
	public String home_field;

	public ContactData() {
	}
	
	public ContactData(String f_name, String l_name, String address,
			String home_phone, String mob_phone, String wrk_phone,
			String f_email, String s_email, String dd_birth, String mm_birth,
			String yyyy_birth, String group_select, String sec_address,
			String home_field) {
		this.f_name = f_name;
		this.l_name = l_name;
		this.address = address;
		this.home_phone = home_phone;
		this.mob_phone = mob_phone;
		this.wrk_phone = wrk_phone;
		this.f_email = f_email;
		this.s_email = s_email;
		this.dd_birth = dd_birth;
		this.mm_birth = mm_birth;
		this.yyyy_birth = yyyy_birth;
		this.group_select = group_select;
		this.sec_address = sec_address;
		this.home_field = home_field;
	}
}