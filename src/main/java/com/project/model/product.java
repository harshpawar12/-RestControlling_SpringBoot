package com.project.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int pro_id;
	    private String pro_name;
	    private String category;
	    private String price;

	    
	    @ManyToOne(fetch = FetchType.LAZY)  
	    @JoinColumn(name = "student_Id")  
	    @JsonBackReference  
	    private student students;

	   
	    public int getPro_id() {
	        return pro_id;
	    }

	    public void setPro_id(int pro_id) {
	        this.pro_id = pro_id;
	    }

	    public String getPro_name() {
	        return pro_name;
	    }

	    public void setPro_name(String pro_name) {
	        this.pro_name = pro_name;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public String getPrice() {
	        return price;
	    }

	    public void setPrice(String price) {
	        this.price = price;
	    }

	    public student getStudents() {
	        return students;
	    }

	    public void setStudents(student students) {
	        this.students = students;
	    }

	    // Constructors
	    public product(int pro_id, String pro_name, String category, String price, student students) {
	        super();
	        this.pro_id = pro_id;
	        this.pro_name = pro_name;
	        this.category = category;
	        this.price = price;
	        this.students = students;
	    }

	    public product() {
	        super();
	    }

	    @Override
	    public String toString() {
	        return "product{" +
	                "pro_id=" + pro_id +
	                ", pro_name='" + pro_name + '\'' +
	                ", category='" + category + '\'' +
	                ", price='" + price + '\'' +
	                ", student=" + (students != null ? students.getStud_id() : "null") +
	                '}';
	    }
	}

