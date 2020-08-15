package com.coffee.sales.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.coffee.sales.employee.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
   User findUserRoleByLoginAcct(String loginAcct);

   @Select({"select id,loginacct,userpassword,username,email,createtime from t_user "})
   List<User> queryAllUser() throws SQLException;

   @Insert({"insert into t_user(loginacct,userpassword,username,email) values(#{loginAcct},#{userPassword},#{userName},#{email})"})
   void saveUser(User user) throws SQLException;

   @Update({"update t_user set loginacct=#{loginAcct},username=#{userName},email=#{email} where id=#{id}"})
   void updateUser(User user) throws SQLException;

   @Delete({"<script>delete from t_user where id in<foreach collection=\"ids\" item=\"id\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{id}</foreach></script>"})
   void deleteUser(@Param("ids") int[] ids) throws SQLException;

   @Insert({"<script>insert into t_user_role(userid,roleid) values <foreach collection=\"roleids\" item=\"roleid\" index=\"index\" open=\"(\" separator=\"),(\" close=\")\">#{userid},#{roleid}</foreach></script>"})
   void saveUserRole(int userid, Integer[] roleids) throws SQLException;

   @Delete({"<script>delete from t_user_role where userid=#{userid} and roleid in<foreach collection=\"roleids\" item=\"roleid\" index=\"index\" open=\"(\" separator=\",\" close=\")\">#{roleid}</foreach></script>"})
   void deleteUserRole(int userid, Integer[] roleids) throws SQLException;
}
