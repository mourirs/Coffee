package com.coffee.sales.employee.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.coffee.sales.employee.bean.Permission;
import com.coffee.sales.employee.bean.Role;
import com.coffee.sales.employee.dao.RoleMapper;
import com.coffee.sales.employee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
   rollbackFor = {Exception.class}
)
public class RoleServiceImpl implements RoleService {
   private final RoleMapper mapper;

   @Autowired
   public RoleServiceImpl(RoleMapper mapper) {
      this.mapper = mapper;
   }

   public List<Role> getAllRoles() throws SQLException {
      return mapper.queryAllRole();
   }

   public List<Permission> getAllPermission() throws SQLException {
      return mapper.queryAllPermission();
   }

   public List<Integer> getPermission(int id) throws SQLException {
      return mapper.queryPermission(id);
   }

   public void saveRoleAndePermission(Integer roleid, Integer[] permission) throws SQLException {
      mapper.saveRoleAndPermission(roleid, permission);
   }

   public void deleteRolePermission(Integer roleid, Integer[] permission) throws SQLException {
      mapper.deleteRolePermission(roleid, permission);
   }

   public void saveRole(String name) throws SQLException {
      mapper.saveRole(name);
   }

   public void updateRole(Role role) throws SQLException {
      mapper.updateRole(role);
   }

   public void deleteRole(Integer[] ids) throws SQLException {
      mapper.deleteRole(ids);
   }
}
