package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
	DataResult<List<EmployerUpdate>> getVerifyed();

    public DataResult<List<EmployerUpdate>> getAll();
}
