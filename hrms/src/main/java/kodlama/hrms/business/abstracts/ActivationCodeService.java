package kodlama.hrms.business.abstracts;

import kodlama.hrms.core.utilities.results.Result;
import kodlama.hrms.entities.concretes.ActivationCode;
import kodlama.hrms.entities.concretes.User;

public interface ActivationCodeService {
	   	ActivationCode getByCode(String code);
	    String createActivationCode(User user);
	    Result activateUser(String code);
}
