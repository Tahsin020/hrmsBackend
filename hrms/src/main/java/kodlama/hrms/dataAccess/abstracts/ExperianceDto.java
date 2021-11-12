package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Experiance;

public interface ExperianceDto extends JpaRepository<Experiance, Integer>{
	List<Experiance> findByCvId(int id);
}
