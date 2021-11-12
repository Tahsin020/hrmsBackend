package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateDao  extends JpaRepository<EmployerUpdate, Integer>{
	@Query("From EmployerUpdate where verifyed = false")
    List<EmployerUpdate> getVerifyed();

}
