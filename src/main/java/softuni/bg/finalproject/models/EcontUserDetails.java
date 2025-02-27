package softuni.bg.finalproject.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class EcontUserDetails extends User {

    private String firstName;
    private String lastName;
    public EcontUserDetails(String username,
                            String password,
                            Collection<? extends GrantedAuthority> authorities,
                            String firstName,
                            String lastName
    ) {
        super(username, password, authorities);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName(){
        StringBuilder fullName = new StringBuilder();
        if (firstName != null){
            fullName.append(firstName);
        }
        if (lastName != null){
            if (!fullName.isEmpty()){
                fullName.append(" ");
            }
            fullName.append(lastName);
        }
        return fullName.toString();
    }
}
