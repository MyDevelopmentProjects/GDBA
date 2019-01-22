package ge.unknown.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by MJaniko on 7/2/2017.
 */
public class UserDetailsDTO {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 21)
    private String firstName;

    @NotEmpty
    @NotNull
    @Size(min = 3, max = 35)
    private String lastName;

    @Email
    private String email;

    @NotEmpty
    @Size(min = 6, max = 15)
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
