package com.example.demo.model;


public class MenuForm {
	private Integer id;
	private String name;
	private String link;
	private Integer ordering;
	private String target;
	
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getOrdering() {
		return ordering;
	}
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}


}
