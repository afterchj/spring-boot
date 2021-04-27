package com.example.demo.service.dubbo;

import com.isoft.after.api.ExternService;
import com.isoft.after.constants.Result;
import com.isoft.after.model.dto.UserDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/12/12.
 */

@Service
public class ExternServiceConsume {

    @Reference
    public ExternService externService;

    public Result<UserDTO> login(String s1, String s2) {
        return externService.login(s1,s2);
    }
}
