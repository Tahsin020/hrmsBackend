package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.ActivationByStaff;

public interface ActivationByStaffDao  extends JpaRepository<ActivationByStaff, Integer>{
	 ActivationByStaff findByEmployeId(int id);
}
