package jit.wxs.service;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Map> getAll();
    void insertUserRole(Map userRole);
}
