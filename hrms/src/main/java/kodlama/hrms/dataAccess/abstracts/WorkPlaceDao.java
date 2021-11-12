package kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceDao extends JpaRepository<WorkPlace, Integer>{

}
