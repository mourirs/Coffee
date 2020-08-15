package com.coffee.sales.employee.service;


import com.coffee.sales.employee.bean.Role;
import com.coffee.sales.employee.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
   User getUserRoleInfo(String loginAcct);

   Role findRolePermissionById(Integer id);

   List<User> queryUser() throws SQLException;

   void saveUser(User user) throws SQLException;

   void updateUser(User user) throws SQLException;

   void delete(int[] ids) throws SQLException;

   List<Role> queryRole(int userId) throws SQLException;

   List<Role> queryAllRole() throws SQLException;

   void saveUserAndRole(int userid, Integer[] roleids) throws SQLException;

   void deleteUserAndRole(int userid, Integer[] roleids) throws SQLException;
}
