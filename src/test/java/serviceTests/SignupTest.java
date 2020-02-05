package serviceTests;

import org.testng.annotations.Test;

import services.SignInRequest;
import services.SignUpRequest;
import utils.DriverInfo;

public class SignupTest extends DriverInfo{

	@Test(priority =0, groups="register")
	public void signUpUsingService() throws Exception {
		test = extent.createTest("Signup Test","Signup test using service");
		SignUpRequest.signupRequest();
		SignUpRequest.signupResponse();
	}
	
	@Test(priority =1,groups="login")
	public void signInUsingService() throws Exception {
		test = extent.createTest("SignIn Test","Login");
		SignInRequest.signinRequest();
		SignInRequest.signinResponse();
	}
}
