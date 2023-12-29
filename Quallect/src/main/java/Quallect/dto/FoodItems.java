package Quallect.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.mysql.cj.jdbc.Blob;

@Entity
public class FoodItems {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String dish_name;
	private String description;
	private Double price;
	@JoinColumn
	@ManyToOne
	private OwnerRegister owner;
	public FoodItems(String dish_name, String description, Double price) {
		super();
		this.dish_name = dish_name;
		this.description = description;
		this.price = price;
	}
	public FoodItems() {
		super();
	}
	@Override
	public String toString() {
		return "FoodItems [id=" + id + ", dish_name=" + dish_name + ", description=" + description + ", price=" + price
				+ ", owner=" + owner + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public OwnerRegister getOwner() {
		return owner;
	}
	public void setOwner(OwnerRegister owner) {
		this.owner = owner;
	}
	
		
	
	
	
}
