package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.WorkTime;



public interface WorkTimeDao extends JpaRepository<WorkTime, Integer> {

}
