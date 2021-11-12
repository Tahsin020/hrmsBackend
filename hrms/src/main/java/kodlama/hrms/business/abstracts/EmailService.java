package kodlama.hrms.business.abstracts;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.User;

public interface EmailService {

	void sendVerifyEmail(User user,String code);
}
