package employeeapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import employeeapplication.domain.Employee;
import employeeapplication.domain.EmployeeRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository empRepository;
	
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++){
			Employee emp = new Employee();
			emp.setName("Employee Name-" + i+1);
			emp.setPhone("919-234-555"+i+1);
			emp.setEmail("emplayee"+i+1+"@test.com");
			empRepository.save(emp);
		}
		
	}
}
