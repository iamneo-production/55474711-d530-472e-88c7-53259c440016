package dao;
import model.User;
public class UserImpl {
	//login user
	@SuppressWarnings("null")
	public String Login(User user)
	{
		IUser user1 = null;
		if (user1.findByUserNameAndUserPassword(user.getUsername(), user.getPassword()) != null) {
			return "Valid Admin, Loggedin Successfully";
		} else {

			return "Incorrect Credentilas, Please Enter correct credentials";

		}
	}
}
