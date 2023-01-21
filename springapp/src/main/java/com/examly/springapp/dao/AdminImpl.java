package dao;
import model.Admin;
public class AdminImpl {
	//login user
	@SuppressWarnings("null")
	public String Login(Admin admin)
	{
		IAdmin admin1 = null;
		if (admin1.findByAdminNameAndAdminPassword(admin.getUsername(), admin.getPassword()) != null) {
			return "Valid Admin, Loggedin Successfully";
		} else {

			return "Incorrect Credentilas, Please Enter correct credentials";

		}
	}
}

