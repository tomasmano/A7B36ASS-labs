package model;


public class Person implements IPerson {
	private Long id;
	private Long salary;
	private Double age;
	private Boolean married;
	private String fName;
	private String lName;

	public Person() {

	}

    @Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Override
	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

    @Override
	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

    @Override
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

    @Override
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

    @Override
	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

}
