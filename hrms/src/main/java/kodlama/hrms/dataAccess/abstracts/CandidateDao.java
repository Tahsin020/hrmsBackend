package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
		Candidate findByNationalNumber(String nationalNumber);
	    Candidate findByEmail(String email);
	    List<Candidate> findByMailVerifyTrue();
}
