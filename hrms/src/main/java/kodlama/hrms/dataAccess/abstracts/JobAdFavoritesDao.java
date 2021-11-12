package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.JobAdFavorites;

public interface JobAdFavoritesDao  extends JpaRepository<JobAdFavorites, Integer>{

	List<JobAdFavorites> findByCandidateId(int id);
    boolean existsByCandidate_IdAndJobAd_Id(int candidateId,int JobAdId);
}
