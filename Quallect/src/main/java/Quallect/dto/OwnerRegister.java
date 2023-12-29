package Quallect.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OwnerRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String restaurantname;
	@Column(unique = true)
	private String email;
	private String pwd;
	private String location;
	private long phone;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
	private List<FoodItems> food;
	@Override
	public String toString() {
		return "OwnerRegister [id=" + id + ", name=" + name + ", restaurantname=" + restaurantname + ", email=" + email
				+ ", pwd=" + pwd + ", location=" + location + ", phone=" + phone + ", food=" + food + "]";
	}
	public OwnerRegister(String name, String restaurantname, String email, String pwd, String location, long phone) {
		super();
		this.name = name;
		this.restaurantname = restaurantname;
		this.email = email;
		this.pwd = pwd;
		this.location = location;
		this.phone = phone;
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
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public List<FoodItems> getFood() {
		return food;
	}
	public void setFood(List<FoodItems> food) {
		this.food = food;
	}
	public OwnerRegister() {
		super();
	}
	
	
	
}
