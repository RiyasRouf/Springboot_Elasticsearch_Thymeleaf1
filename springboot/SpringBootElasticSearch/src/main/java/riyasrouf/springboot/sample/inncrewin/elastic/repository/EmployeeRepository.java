package riyasrouf.springboot.sample.inncrewin.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import riyasrouf.springboot.sample.inncrewin.elastic.model.Employee;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String>
{

    public List<Employee> findByFirstNameContaining(String firstName);

	public List<Employee> findByJob(String job);
}
