package com.coffee.sales.employee.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.coffee.sales.employee.bean.Role;
import com.coffee.sales.employee.bean.User;
import com.coffee.sales.employee.dao.RoleMapper;
import com.coffee.sales.employee.dao.UserMapper;
import com.coffee.sales.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
   rollbackFor = {Exception.class}
)
public class UserServiceImpl implements UserService {
   private final UserMapper userMapper;
   private final RoleMapper roleMapper;

   @Autowired
   public UserServiceImpl(UserMapper userMapper, RoleMapper roleMapper) {
      this.userMapper = userMapper;
      this.roleMapper = roleMapper;
   }

   public User getUserRoleInfo(String loginAcct) {
      return userMapper.findUserRoleByLoginAcct(loginAcct);
   }

   public Role findRolePermissionById(Integer id) {
      return roleMapper.findRolePermissionById(id);
   }

   public List<User> queryUser() throws SQLException {
      return userMapper.queryAllUser();
   }

   public void saveUser(User user) throws SQLException {
      userMapper.saveUser(user);
   }

   public void updateUser(User user) throws SQLException {
      userMapper.updateUser(user);
   }

   public void delete(int[] ids) throws SQLException {
      userMapper.deleteUser(ids);
   }

   public List<Role> queryRole(int userId) throws SQLException {
      return roleMapper.queryRole(userId);
   }

   public List<Role> queryAllRole() throws SQLException {
      return roleMapper.queryAllRole();
   }

   public void saveUserAndRole(int userid, Integer[] roleids) throws SQLException {
      userMapper.saveUserRole(userid, roleids);
   }

   public void deleteUserAndRole(int userid, Integer[] roleids) throws SQLException {
      userMapper.deleteUserRole(userid, roleids);
   }
}
