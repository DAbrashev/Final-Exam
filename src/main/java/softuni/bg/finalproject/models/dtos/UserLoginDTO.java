package softuni.bg.finalproject.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {

    @Email
    private String email;

    @Size(min = 6, max = 24)
    private String password;

    public UserLoginDTO() {
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
}
