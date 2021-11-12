package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employer;
import kodlama.hrms.entities.concretes.EmployerUpdate;
import kodlama.hrms.entities.dtos.EmployerForRegisterDto;

public interface EmployerService {

		DataResult<List<Employer>> getAll();
	    DataResult<Employer> getByEmail(String email);
	    Result add(EmployerForRegisterDto employerDto);
	    DataResult<Employer> getById(int id);
	    Result update(EmployerUpdate employerUpdate);
	    Result verifyUpdate(int employerUpdateId,int staffId);
}
