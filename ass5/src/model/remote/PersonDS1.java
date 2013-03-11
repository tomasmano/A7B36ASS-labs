package model.remote;


public class PersonDS1 implements IPersonDS1 {
	Long id;
	Long salary;
	Double age;
	Long partner;
	String name;

	public PersonDS1() {

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
	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

    @Override
	public Long getPartner() {
		return partner;
	}

	public void setPartner(Long partner) {
		this.partner = partner;
	}

    @Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
