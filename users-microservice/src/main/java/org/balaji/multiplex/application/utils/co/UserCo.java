package org.balaji.multiplex.application.utils.co;

import lombok.Data;
import org.balaji.multiplex.commons.domain.Roles;

import java.util.Set;

@Data
public class UserCo {


    public String username;

    public String email;

    public String firstName;

    public String lastName;

    public Set<Roles> roles;

    public Boolean isActive;

    public Boolean isDeleted = false;

    public String password = "password@123";

}
