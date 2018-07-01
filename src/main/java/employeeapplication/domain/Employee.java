package employeeapplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String type;
	private String age;
	private String email;
	private String phone;
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String eName) {
		this.name = eName;
	}

	public String getType() {
		return type;
	}

	public void setType(String eType) {
		this.type = eType;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String eAge) {
		this.age = eAge;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String eEmail) {
		this.email = eEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String ePhone) {
		this.phone = ePhone;
	}

	public Employee(){
		
	}
	public Employee(String name, String phone, String email){
		this.name = name;
		this.phone = phone;
		this.email = email;
		
	}
}
