package Student_Database_Management_Project;
import java.util.Random;
public class CaptchVerification {
	 char[] captcha(int len) {
		String numbers="ABC1DEFGH2IJKLM3NOPQRS4TUVWX5YZab6cdef7ghijk8lmno0pqrstuvwxyz9";
		Random rndm_method=new Random();
		char otp[] =new char[len];
		for(int i=0;i<len;i++) {
			otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}
	
}
