package dao;

import org.springframework.data.repository.CrudRepository;

import model.Admin;

public interface IAdmin extends CrudRepository<Admin,Integer> {
	public Admin findByAdminNameAndAdminPassword(String username, String userpassword);
}
