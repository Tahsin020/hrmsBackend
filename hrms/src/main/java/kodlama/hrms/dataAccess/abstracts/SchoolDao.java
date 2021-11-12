package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	List<School> findByCvId(int id);
}
