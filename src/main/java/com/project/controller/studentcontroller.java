package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.product;
import com.project.model.student;
import com.project.repo.productrepo;
import com.project.repo.studentrepo;

@RestController
public class studentcontroller {
	
	@Autowired
	studentrepo Repo;
	@Autowired
	productrepo prorepo;
	
	student currStudent;
	//-------Insert Section "student" & "product" -------------
	@RequestMapping("/std")
	public String isInsert(@ModelAttribute student ob)
	{
		Repo.save(ob);
		currStudent=ob;
		return "Student Data inserted Successfully....";
	}
	@RequestMapping("/pro")
	public String isInsertPro(@ModelAttribute product pob) {
	    if (currStudent != null) {
	        pob.setStudents(currStudent);

	        if (currStudent.getProducts() == null) {
	            currStudent.setProducts(new ArrayList<>());
	        }

	        currStudent.getProducts().add(pob);
	        prorepo.save(pob);
	        Repo.save(currStudent);

	        return "Product inserted successfully with linked student.";
	    }
	    return "Product not inserted. No student found!";
	}
	//-------------Fetch Data "student" & "product" ---------------
	@RequestMapping("/fetchstd")
	public List<student> isFetch()
	{
		List<student>al= Repo.findAll();
		return al;
	}
	@RequestMapping("/fetchpro")
	public List<product> isFetch1()
	{
		List<product>al= prorepo.findAll();
		return al;
	}
	//-------------Delete Data "student" & "product" ---------------
	@RequestMapping("/del/{stud_id}")
	public String isdeleStudent(@PathVariable int stud_id)
	{
		Repo.deleteById(stud_id);
		return "student deleted Successfully....";
	}
	@RequestMapping("/del1/{pro_id}")
	public String isdelepro(@PathVariable int pro_id)
	{
		prorepo.deleteById(pro_id);
		return "product deleted Successfully....";
	}
	//-------------Serch Data "student" & "product" ---------------
	@RequestMapping("/serch/{stud_id}")
	public student isselect(@PathVariable int stud_id)
	{
	student s=Repo.findById(stud_id).orElse(new student());
	return s;
		
	}
	@RequestMapping("/serch1/{pro_id}")
	public product isselectpro(@PathVariable int pro_id)
	{
	product s=prorepo.findById(pro_id).orElse(new product());
	return s;
	}
	//-------------Update Data "student" & "product" ---------------
	@RequestMapping("/up/{stud_id}")
	public String isupstud(student ob)
	{
		student ss=Repo.findById(ob.getStud_id()).get();
		if(ob.getStud_name()!=null)
		{
			ss.setStud_name(ob.getStud_name());
		}else {
			ob.getStud_name();
		}
		if(ob.getAge()!=null)
		{
			ss.setAge(ob.getAge());
		}else {
			ob.getAge();
		}
		Repo.save(ss);
		return "Student Data Updated....";

	}
	@RequestMapping("/up1/{pro_id}")
	public String isuppro(product ob)
	{
		product ss=prorepo.findById(ob.getPro_id()).get();
		if(ob.getPro_name()!=null)
		{
			ss.setPro_name(ob.getPro_name());
		}else {
			ob.getPro_name();
		}
		if(ob.getCategory()!=null)
		{
			ss.setCategory(ob.getCategory());
		}else {
			ob.getCategory();
		}
		if(ob.getPrice()!=null)
		{
			ss.setPrice(ob.getPrice());
		}else {
			ob.getPrice();
		}
		prorepo.save(ss);
		return "product Data Updated....";

	}
	//  ----------Thanks To seeing out Relation.


}
