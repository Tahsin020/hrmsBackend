package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	Cv findByCandidateId(int id);
}
