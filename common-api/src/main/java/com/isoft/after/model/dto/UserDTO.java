package com.isoft.after.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String loginType;
    private String ip;
}
