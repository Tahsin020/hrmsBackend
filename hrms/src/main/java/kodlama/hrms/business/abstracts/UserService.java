package kodlama.hrms.business.abstracts;

import java.util.List;

import kodlama.hrms.core.utilities.results.DataResult;
import kodlama.hrms.entities.concretes.User;
import kodlama.hrms.entities.dtos.UserLoginDto;
import kodlama.hrms.entities.dtos.UserLoginReturnDto;

public interface UserService {
	DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
    DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto);
    DataResult<List<User>> getVerifyedUsers();
}
