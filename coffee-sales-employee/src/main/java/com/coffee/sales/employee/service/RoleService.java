package com.coffee.sales.employee.service;


import com.coffee.sales.employee.bean.Permission;
import com.coffee.sales.employee.bean.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleService {
   List<Role> getAllRoles() throws SQLException;

   List<Permission> getAllPermission() throws SQLException;

   List<Integer> getPermission(int id) throws SQLException;

   void saveRoleAndePermission(Integer roleid, Integer[] permission) throws SQLException;

   void deleteRolePermission(Integer roleid, Integer[] permission) throws SQLException;

   void saveRole(String name) throws SQLException;

   void updateRole(Role role) throws SQLException;

   void deleteRole(Integer[] ids) throws SQLException;
}
