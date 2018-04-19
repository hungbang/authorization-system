package system.authorization.request;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by KAI on 4/19/18.
 */
public class RegistrationRequest {

    @Email
    @NotNull(message = "Email is required.")
    private String email;
    private String password;
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @AssertTrue(message = "Password confirmation not matching")
    public boolean isConfirmPassword(){
        return (Objects.nonNull(this.confirmPassword) && this.confirmPassword.equalsIgnoreCase(this.password));
    }


    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("android-secret"));

    }


}
