package demo.vo;

public  class EmployeeBuilder {
	private String name;
	private String occupation;
	private int age;
	
	public Employee build() {
		return new Employee(this.name, this.occupation, this.age);
	}

	

	public EmployeeBuilder setName(String name) {
		this.name = name;
		return this;
	}

	

	public EmployeeBuilder setOccupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	
	public EmployeeBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	
	
}
