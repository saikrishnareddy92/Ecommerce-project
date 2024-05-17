package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Seller {
	@Id @GeneratedValue
	private int sid;
	@Column
	private String name;
	@Column
	private long originalprice;
	@Column
	private String description;
	@Column
	private String imageURL;
	@Column
	private long offerprice;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getOriginalprice() {
		return originalprice;
	}
	public void setOriginalprice(long originalprice) {
		this.originalprice = originalprice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public long getOfferprice() {
		return offerprice;
	}
	public void setOfferprice(long offerprice) {
		this.offerprice = offerprice;
	}
	
	

}
