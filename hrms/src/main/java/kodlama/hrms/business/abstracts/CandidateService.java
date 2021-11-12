package kodlama.hrms.business.abstracts;

import java.util.List;



import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Candidate;
import kodlama.hrms.entities.dtos.CandidateForRegisterDto;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
    DataResult<Candidate> getByNationalNumber(String nationalNumber);
    DataResult<Candidate> getByEmail(String email);
    Result add(CandidateForRegisterDto candidateForRegisterDto);
    DataResult<List<Candidate>> getMailVerifyTrue();
	
}
