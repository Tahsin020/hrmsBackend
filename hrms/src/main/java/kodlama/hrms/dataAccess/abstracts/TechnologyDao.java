package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{
	 List<Technology> findByCvId(int id);
}
