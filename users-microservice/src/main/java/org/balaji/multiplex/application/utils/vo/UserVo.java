package org.balaji.multiplex.application.utils.vo;

import lombok.Data;
import org.balaji.multiplex.commons.domain.Roles;
import org.balaji.multiplex.commons.util.vo.BaseVo;

import java.util.Set;

@Data
public class UserVo extends BaseVo {

    private Integer userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Roles> roles;
    private String password;

}
