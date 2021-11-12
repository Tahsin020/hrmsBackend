package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{
	Staff findById(int id);
}
