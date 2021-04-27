package com.isoft.after.api;

import com.isoft.after.constants.Result;
import com.isoft.after.model.dto.UserDTO;

public interface ExternService {

    Result<UserDTO> login(String username, String password);
}
