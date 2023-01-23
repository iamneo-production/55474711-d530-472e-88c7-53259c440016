package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import model.User;

public interface IUser extends JpaRepository<User,String> {
	//public User findByUserNameAndUserPassword(String username, String userpassword);
}
