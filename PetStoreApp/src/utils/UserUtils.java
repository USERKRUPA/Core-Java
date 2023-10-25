package utils;

import javax.security.sasl.AuthenticationException;

public interface UserUtils {
	static String authenticateUser(String userid, String pass) throws AuthenticationException {
		if(userid.equals("admin") && pass.equals("admin"))
			return "admin";
		if(userid.equals("c1") && pass.equals("c1"))
			return "user";
		throw new AuthenticationException("Invalid userid and password");
	}
}
