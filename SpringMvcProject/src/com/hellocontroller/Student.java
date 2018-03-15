package com.hellocontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Student {
	@Pattern(regexp="[^0-9]*")
	private String studentName;
	@Size(min=2, max=20 /*, message="Please enter a value for StudentHobby field between {min} and {max}."*/)
	@IsValidHobby
	private String studentHobbys;
	
	private Long studentMobile;
	@Past//it mean that DOB schould not beeing  in future  , it schould be less than the date of today!!
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	private Adress studentAdress;
	
	
	public Adress getStudentAdress() {
		return studentAdress;
	}
	public void setStudentAdress(Adress studentAdress) {
		this.studentAdress = studentAdress;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobbys() {
		return studentHobbys;
	}
	public void setStudentHobbys(String studentHobbys) {
		this.studentHobbys = studentHobbys;
	}

}
