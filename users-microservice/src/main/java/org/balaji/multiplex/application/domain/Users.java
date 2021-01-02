package org.balaji.multiplex.application.domain;

import lombok.Data;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.domain.Roles;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;


@Data
@Document(collection = "users")
public class Users extends BaseEntity {

    @Field("userId")
    private Integer userId;

    @Field("username")
    private String username;

    @Field("email")
    private String email;

    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Field("roles")
    private Set<Roles> roles;

    @Field("password")
    private String password;


}
