package riyasrouf.springboot.sample.inncrewin.elastic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import riyasrouf.springboot.sample.inncrewin.elastic.model.Employee;
import riyasrouf.springboot.sample.inncrewin.elastic.repository.EmployeeRepository;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(Model model)
    {
        List<Employee> employees = new ArrayList<Employee>();

        Iterable<Employee> emps = employeeRepository.findAll();
        for(Employee employ:emps){
        	employees.add(employ);
        }
        model.addAttribute("employees", employees);
        model.addAttribute("employeesCount", employees.size());
        model.addAttribute("searchStr", "");

        return "welcome";
    }

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String searchAlbums(@RequestParam(value="firstname") String firstname, Model model)
    {

        List<Employee> employees = new ArrayList<Employee>();

        Iterable<Employee> emps = employeeRepository.findByFirstNameContaining(firstname);
        
        for(Employee employ:emps){
        	employees.add(employ);
        }

        model.addAttribute("employees", employees);
        model.addAttribute("employeesCount", employees.size());
        model.addAttribute("searchStr", firstname);

        return "welcome";
    }
    @RequestMapping(value="searchjob", method = RequestMethod.POST)
    public String searchjob(@RequestParam(value = "job")String job,Model model)
    {
    	List<Employee> employees = new ArrayList<Employee>();
    	Iterable<Employee> emps = employeeRepository.findByJob(job);
    	
    	for(Employee employ:emps){
        	employees.add(employ);
        }
    	model.addAttribute("employees", employees);
    	model.addAttribute("employeesCount",employees.size());
    	model.addAttribute("searchStr",job);
    	
    	
    	return "welcome";
    }

}
