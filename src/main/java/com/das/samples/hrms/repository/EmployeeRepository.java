package com.das.samples.hrms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.das.samples.hrms.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository
		extends
			MongoRepository<EmployeeEntity, String> {

	void save(List<EmployeeEntity> employeesList);

	@Query(value = "{'officeAddressEntity.city':?0}")
	List<EmployeeEntity> findByCity(String cityName);

	@Query(value = "{'designationEntity':?0}")
	List<EmployeeEntity> findByDesignation(String designation);
	
	@Query(value = "{'designationEntity':?0, 'officeAddressEntity.city':?1}")
	List<EmployeeEntity> findByDesignationAndCity(String designation, String city);
}
