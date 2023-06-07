package dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Doctor11 {
	@Id
	@GeneratedValue(generator="ab")
	@SequenceGenerator(initialValue=1233479,allocationSize=1,name="ab",sequenceName="ab")
	private int id;
	private String name;
	private String email;
	private String password;
	private String gander;
	private long phone;
	private int age;
	private boolean stutas;
	private String qulification;
	private String specilization;
	private Date dob;
	private boolean available;
	@OneToMany
	List<Appointment> appoit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGander() {
		return gander;
	}
	public void setGander(String gander) {
		this.gander = gander;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isStutas() {
		return stutas;
	}
	public void setStutas(boolean stutas) {
		this.stutas = stutas;
	}
	public String getQulification() {
		return qulification;
	}
	public void setQulification(String qulification) {
		this.qulification = qulification;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public List<Appointment> getAppoit() {
		return appoit;
	}
	public void setAppoit(List<Appointment> appoit) {
		this.appoit = appoit;
	}	}
