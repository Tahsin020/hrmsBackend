package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.JobAdActivation;

public interface JobAdActivationDao extends JpaRepository<JobAdActivation, Integer>{

}
