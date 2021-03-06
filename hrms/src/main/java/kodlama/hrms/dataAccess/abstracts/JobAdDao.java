package kodlama.hrms.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.hrms.entities.concretes.JobAd;
import kodlama.hrms.entities.dtos.JobAdFilter;

public interface JobAdDao extends JpaRepository<JobAd, Integer>{
	 	List<JobAd> findByActive(boolean active);
	    List<JobAd> findByActiveOrderByLastDate(boolean active);
	    List<JobAd> findByActiveTrueAndEmployer_Id(int id);



	    @Query("From JobAd where confirmed = false")
	    List<JobAd> getWaitingJobAdvertisements();


	    @Query("Select j from com.hrms.hrms.entities.concretes.JobAd j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
	        +" and ((:#{#filter.workPlaceId}) IS NULL OR j.workPlace.id IN (:#{#filter.workPlaceId}))"
	        +" and ((:#{#filter.workTimeId}) IS NULL OR j.workTime.id IN (:#{#filter.workTimeId}))"
	        +" and j.active=true")
	    public Page<JobAd> getByFilter(@Param("filter") JobAdFilter jobAdFilter, Pageable pageable);
}
