package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("")
	public String home(HttpServletRequest req) {
		System.out.println("hi");
		System.out.println("naem is "+req.getParameter("name"));
		HttpSession session = req.getSession();
		session.setAttribute("name", req.getParameter("name"));
		return "Home";
	}
	
	@RequestMapping("page")
	public ModelAndView page(RequestData data) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", data);
		mv.setViewName("page");
		return mv;
	}
	
	@RequestMapping("addStudent")
	public void addStudent(Student student) {
		repo.save(student);
	}
	
	@RequestMapping("getStudent")
	public ModelAndView getStudent(@RequestParam int sid) {
		ModelAndView mv = new ModelAndView("GetStudent");
		Student student = repo.findById(sid).orElse(new Student());
		mv.addObject(student);
		System.out.println("Student: "+ student);
		System.out.println(repo.findByName("Pratik Gupta"));
		return mv;
	}
	
	@RequestMapping(path="students")
	@ResponseBody
	public List<Student> allStudents(){
		return repo.findAll();
	}
	
	@RequestMapping(path="student", method =RequestMethod.POST)
	@ResponseBody
	public Student student(Student student) {
		System.out.println("inside post");
		repo.save(student);
	//	return "Home"; This also works
		return student;
	}
	@RequestMapping(path="student", method =RequestMethod.PUT)
	@ResponseBody
	public Student saveOrUpdateStudent(Student student) {
		System.out.println("inside put");
		repo.save(student);
	//	return "Home"; This also works
		return student;
	}
	
	@RequestMapping("students/{sid}")
	@ResponseBody
	public Optional<Student> students(@PathVariable("sid") int sid) {
		System.out.println(repo.findById(sid));
		return repo.findById(sid);
	}
	
	@DeleteMapping("student/{sid}")
	@ResponseBody
	public String deleteStudent(@PathVariable int sid) {
		System.out.println("deleteing");
		Student s = repo.getOne(sid);
		repo.delete(s);
		return "Deleted";
	}
}
