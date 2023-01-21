package dao;

import org.springframework.data.repository.CrudRepository;

import model.User;

public interface IUser extends CrudRepository<User,Integer> {
	public User findByUserNameAndUserPassword(String username, String userpassword);
}
