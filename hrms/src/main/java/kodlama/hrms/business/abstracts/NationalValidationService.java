package kodlama.hrms.business.abstracts;

import kodlama.hrms.entities.concretes.Candidate;

public interface NationalValidationService {
	  boolean validate(Candidate candidate);
}
