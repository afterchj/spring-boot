package com.isoft.after.api;

import com.isoft.after.exception.BaseException;
import com.isoft.after.model.dto.UserDTO;

public interface ExternService {

    UserDTO login(String username, String password) throws BaseException;
}
