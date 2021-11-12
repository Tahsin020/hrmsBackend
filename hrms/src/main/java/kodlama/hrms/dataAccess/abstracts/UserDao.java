package kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	 	User findByEmail(String email);
	    List<User> findByMailVerifyTrue();
}
