package kodlama.hrms.business.abstracts;


import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.Employer;

public interface ActivationByStaffService {
	 	void createActivationByStaff(Employer employer);
	    Result activateEmployer(int employerId,int staffId);
}
