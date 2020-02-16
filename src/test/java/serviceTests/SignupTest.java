package serviceTests;

import org.testng.annotations.Test;

import services.SignUpRequest;
import utils.DriverInfo;

public class SignupTest extends DriverInfo {

	@Test(enabled = false, priority = 0, groups = "register")
	public void signUpUsingService() throws Exception {
		test = extent.createTest("Signup Test", "Signup test using service");
		SignUpRequest.signupRequest();
		SignUpRequest.signupResponse();
		SignUpRequest.verifySignUpResponse();
	}	
}
