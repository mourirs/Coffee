package com.coffee.sales.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.coffee.sales.employee.bean.Permission;
import com.coffee.sales.employee.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleMapper {
   Role findRolePermissionById(Integer id);

   @Select({"select id,name from t_role where id in (select roleid from t_user_role where userid = #{userId})"})
   List<Role> queryRole(int userId) throws SQLException;

   @Select({"select id,name from t_role"})
   List<Role> queryAllRole() throws SQLException;

   @Select({"select id,pid,name,icon,url from t_permission where not isnull(url)"})
   List<Permission> queryAllPermission() throws SQLException;

   @Select({"select id from t_permission where id in(select permissionid from t_role_permission where roleid = #{id})"})
   List<Integer> queryPermission(int id) throws SQLException;

   @Insert({"<script>insert into t_role_permission(roleid,permissionid) values <foreach collection='permissionid' item='peid' open='(' separator='),(' close=')'>#{roleid},#{peid}</foreach></script>"})
   void saveRoleAndPermission(Integer roleid, Integer[] permissionid) throws SQLException;

   @Delete({"<script>delete from t_role_permission where roleid=#{roleid} and permissionid in <foreach collection='permissionid' item='peid' open='(' separator=',' close=')'>#{peid} </foreach></script>"})
   void deleteRolePermission(Integer roleid, Integer[] permissionid) throws SQLException;

   @Insert({"insert into t_role(name) values(#{name})"})
   void saveRole(String name) throws SQLException;

   @Update({"update t_role set name=#{name} where id=#{id}"})
   void updateRole(Role role) throws SQLException;

   @Delete({"<script>delete from t_role where id in<foreach collection=\"ids\" item=\"id\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{id}</foreach></script>"})
   void deleteRole(@Param("ids") Integer[] ids) throws SQLException;
}
