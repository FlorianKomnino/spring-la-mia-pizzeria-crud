package org.java.demo.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String description;
	private String imgUrl;
	private Integer priceInCents;
	
	public Pizza() { }
	public Pizza(String name, String description, String imgUrl, Integer priceInCents) {
		setName(name);
		
		setDescription(description);
		setImgUrl(imgUrl);
		setPriceInCents(priceInCents);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getPriceInCents() {
		return priceInCents;
	}
	public void setPriceInCents(Integer priceInCents) {
		this.priceInCents = priceInCents;
	}
	public Float priceInFloat() {
		float formattedPrice = getPriceInCents() / (float) 100;
		return formattedPrice;
	}
	
	@Override
	public String toString() {
		
		return "\n[" + id + "]"
				+ "\nNome: " + name
				+ "\nDescrizione: " + getDescription()
				+ "\nPrezzo: " + priceInFloat()
				+ "\n-------------------------";
	}
}