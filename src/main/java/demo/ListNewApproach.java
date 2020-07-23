package demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import demo.vo.Employee;
import demo.vo.EmployeeBuilder;

@Component
public class ListNewApproach {

	//public static void main(String[] args) {
		
		public void removeAndUserMain() {
		EmployeeBuilder empBuilder= new EmployeeBuilder();
		List<Employee> employeeList= new ArrayList();
		employeeList.add(empBuilder.setAge(10).setOccupation("swEngg1").setName("abc1").build());	
		employeeList.add(empBuilder.setAge(11).setOccupation("swEngg2").setName("abc2").build());
		employeeList.add(empBuilder.setAge(12).setOccupation("swEngg3").setName("abc3").build());
		employeeList.add(empBuilder.setAge(13).setOccupation("swEngg4").setName("abc1").build());
		
		employeeList.sort(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
			return	o1.getAge()>o2.getAge()?-1:(o1.getAge()<o2.getAge()?1:0);
			}
		});
		
		employeeList.forEach(emp-> System.out.println(emp.getName()));

		employeeList.sort((o1,o2)->o1.getAge()>o2.getAge()?1:(o1.getAge()<o2.getAge()?-1:0) );
		employeeList.forEach(emp-> System.out.println(emp.getName()));
		
		List<String> intList= new ArrayList();
		intList.add("1");
		intList.add("2");
		intList.add("1");
		
	Map<String, Long> map=	intList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	map.entrySet().forEach(System.out::println);
	
	Map<Object,Long> map2=employeeList.stream().collect(Collectors.groupingBy(e->e.getName(),Collectors.counting()));
	map2.entrySet().forEach(System.out::println);
		employeeList.replaceAll(e->{
			if(e.getOccupation().contains("1")) {
				return e;
			}else {
				e.setOccupation(e.getOccupation()+"1");
				return e;
			}
		});
		
		employeeList.forEach(emp->{
			emp.setOccupation(emp.getOccupation().concat("again"));
			System.out.println(emp.getOccupation());
		});
		


	}


}
