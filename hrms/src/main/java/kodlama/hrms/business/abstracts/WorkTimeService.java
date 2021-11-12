package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.WorkTime;

public interface WorkTimeService {
	 DataResult<List<WorkTime>> getAll();
}
