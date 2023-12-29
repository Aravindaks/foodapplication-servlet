package Quallect.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CustomerRegister {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String pwd;
	private String address;
	private long phone;
	@ManyToMany
	private List<FoodItems> food;
	public CustomerRegister(String name, String email, String pwd, String address, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.address = address;
		this.phone = phone;
	}
	
	
	public List<FoodItems> getFood() {
		return food;
	}


	public void setFood(List<FoodItems> food) {
		this.food = food;
	}


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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public CustomerRegister() {
		super();
	}


	@Override
	public String toString() {
		return "CustomerRegister [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", address="
				+ address + ", phone=" + phone + ", food=" + food + "]";
	}
	
	
	
}
