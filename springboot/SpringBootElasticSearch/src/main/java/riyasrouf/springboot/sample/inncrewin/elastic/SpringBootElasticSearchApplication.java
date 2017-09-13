package riyasrouf.springboot.sample.inncrewin.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import riyasrouf.springboot.sample.inncrewin.elastic.model.Employee;
import riyasrouf.springboot.sample.inncrewin.elastic.repository.EmployeeRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootElasticSearchApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootElasticSearchApplication.class, args);
    }

    @PostConstruct
    private void init()
    {
        employeeRepository.save(new Employee("1", "Manju", "Nair", "Manager"));
        employeeRepository.save(new Employee("2", "Fahad", "CV", "Tech Lead"));
        employeeRepository.save(new Employee("3", "Manoj", "Paul", "Tech Lead"));
        employeeRepository.save(new Employee("4", "Divya", "Deepu Narayan", "Tech Lead"));
        employeeRepository.save(new Employee("5", "Zameer", "Shaik", "Tech Lead"));
        employeeRepository.save(new Employee("6", "Guru", "Moorthi", "Architect"));
        employeeRepository.save(new Employee("7", "Muhammed", "Riyas", "Senior Developer"));
        employeeRepository.save(new Employee("8", "Abdul", "Riyas", "Software Engineer"));
    }
}
