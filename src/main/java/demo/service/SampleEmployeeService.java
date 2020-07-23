package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.vo.Employee;

@RestController
@RequestMapping("/api/emp")
public class SampleEmployeeService {
	
	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	 @ResponseBody
	 public List<Employee> findEmployee() {
	  return makeListEmployees();
	 }
	
	
	private List<Employee> makeListEmployees(){
		List<Employee> elist= new ArrayList<>();
		elist.add(new Employee("abc", "manager", 45));
		elist.add(new Employee("abc1", " senior manager", 35));
		elist.add(new Employee("abc2", "developer", 30));
		elist.add(new Employee("abc3", "lead", 33));
		elist.add(new Employee("abc4", "junior", 25));

		
		return elist;
	}

}
