package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	    DataResult<List<JobPosition>> getAll();
	    Result add(JobPosition jobPosition);
	    DataResult<JobPosition> getByName(String name);
}
