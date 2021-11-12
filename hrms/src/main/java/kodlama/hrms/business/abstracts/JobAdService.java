package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobAd;
import kodlama.hrms.entities.dtos.JobAdDto;
import kodlama.hrms.entities.dtos.JobAdFilter;


public interface JobAdService {

		Result create(JobAdDto jobAdDto);
	    Result setPasssive(int jobAdId);
	    Result setActiveAndConfirm(int jobAdId,int staffId);
	    DataResult<List<JobAd>> getAll();
	    DataResult<JobAd> getByJobAdId(int id);
	    DataResult<List<JobAd>> getActiveAds();
	    DataResult<List<JobAd>> getActiveAndOrderLastDate();
	    DataResult<List<JobAd>> getWaitingJobAdvertisements();

	    DataResult<List<JobAd>> getActiveAndCompanyId(int id);
	    DataResult<List<JobAd>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobAdFilter jobAdFilter);
	

}
