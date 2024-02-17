package main;

public class Karyawan {
	//Attribute
	private String idCode;
	private String name;
	private String gender;
	private String position;
	private int salary;
	
	public Karyawan(String idCode, String name, String gender, String position, int salary) {
		this.idCode = idCode;
		this.name = name;
		this.gender = gender;
		this.position = position;
		this.salary = salary;
	}
	
	public void selfIntro() {
		System.out.printf("|%17s|%31s|%16s|", idCode, name, gender);
		System.out.printf("%17s|%18d|\n", position, salary);
//		System.out.println("Name     : " + name);
//		System.out.println("ID       : " + idCode);
//		System.out.println("Gender   : " + gender);
	}
	
	public String getIdCode() {
		return idCode;
	}
	
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
