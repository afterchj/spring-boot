package com.example.demo.service.dubbo;

import com.isoft.after.api.ExternService;
import com.isoft.after.constants.Result;
import com.isoft.after.model.dto.UserDTO;
import com.isoft.after.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;


/**
 * Created by hongjian.chen on 2018/12/12.
 */

@Slf4j
@Service
public class ExternServiceConsume {

    @DubboReference(version = "0.2.0")
    public ExternService externService;

    public Result<UserDTO> login(String s1, String s2) {
        try {
            UserDTO userDTOResult = externService.login(s1, s2);
            return ResponseUtil.SUCCESS(userDTOResult);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("msg {} clazz {}", e.getMessage(), e.getClass());
            return ResponseUtil.Failure(e.getMessage());
        }
    }
}
