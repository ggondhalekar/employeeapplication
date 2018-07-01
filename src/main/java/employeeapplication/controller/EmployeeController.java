package employeeapplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employeeapplication.domain.Employee;
import employeeapplication.domain.EmployeeRepository;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employeeList")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET )
	public String listOfEmployees(Model model){
		model.addAttribute("employeeList", empRepository.findAll());
		return "employee/list";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.GET )
	public ModelAndView delete(@PathVariable Long id){
		empRepository.deleteById(id);
		return new ModelAndView("redirect:/employeeList");
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET )
	public String newEmployee(){
		return "employee/newEmployee";
	}
	
	@RequestMapping(value="/employeeList/create", method=RequestMethod.POST )
	public ModelAndView create(@RequestParam("name") String name,
						@RequestParam("phone") String phone,
						@RequestParam("email") String email){
		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setPhone(phone);
		empRepository.save(emp);
		return new ModelAndView("redirect:/employeeList");
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET )
	public String edit(@PathVariable Long id,
							Model model){
		Optional<Employee> empOptional = empRepository.findById(id);
		if (empOptional.isPresent()){
		    Employee emp = empOptional.get();
		    model.addAttribute("employee",emp);
		}    
		return "employee/updateEmployee";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST )
	public ModelAndView update(@RequestParam("id") long id,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email){
		System.out.println("inside update"+name+phone+email);
		Optional<Employee> empOptional = empRepository.findById(id);
		if (empOptional.isPresent()){
		    Employee emp = empOptional.get();
		    emp.setName(name);
			emp.setEmail(email);
			emp.setPhone(phone);
			empRepository.save(emp);
			System.out.println("afterSave");
		}
		return new ModelAndView("redirect:/employeeList");
	}
}
