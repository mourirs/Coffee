package com.coffee.sales.employee.controller;

import com.coffee.sales.employee.bean.Role;
import com.coffee.sales.employee.bean.User;
import com.coffee.sales.employee.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"user"})
public class UserController {
   @Autowired
   private UserService service;
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @RequestMapping({"get"})
   public String getUser(Model model) throws SQLException {
      PageHelper.startPage(1, 5);
      List<User> users = this.service.queryUser();
      PageInfo<User> page = new PageInfo(users);
      model.addAttribute("page", page);
      return "user/user";
   }

   @RequestMapping({"getPage"})
   @ResponseBody
   public PageInfo<User> getPageUser(@RequestParam(defaultValue = "1") Integer pageNum) throws SQLException {
      PageHelper.startPage(pageNum, 5);
      List<User> users = this.service.queryUser();
      PageInfo<User> page = new PageInfo(users);
      return page;
   }

   @RequestMapping({"save"})
   @ResponseBody
   public String saveUser(User user) throws SQLException {
      String encode = this.bCryptPasswordEncoder.encode(user.getUserPassword());
      user.setUserPassword(encode);
      this.service.saveUser(user);
      return "success";
   }

   @RequestMapping({"updateUser"})
   @ResponseBody
   public String updateUser(User user) throws SQLException {
      this.service.updateUser(user);
      return "update success";
   }

   @RequestMapping({"delete"})
   @ResponseBody
   public String deleteUser(@RequestParam("ids[]") int[] ids) throws SQLException {
      this.service.delete(ids);
      return "Delete Success";
   }

   @GetMapping({"role"})
   public String getRole(int userid, Model model) throws SQLException {
      List<Role> roles = this.service.queryRole(userid);
      List<Role> allRoles = this.service.queryAllRole();
      allRoles.removeAll(roles);
      model.addAttribute("roles", roles);
      model.addAttribute("allRoles", allRoles);
      model.addAttribute("userid", userid);
      return "user/assignRole";
   }

   @PostMapping({"updateRole"})
   @ResponseBody
   public String updateUserAndRole(int userid, @RequestParam(value = "leftparam[]",defaultValue = "") Integer[] leftparam, @RequestParam(value = "rightparam[]",defaultValue = "") Integer[] rightparam) throws SQLException {
      Integer[] delete = (Integer[])Arrays.copyOf(leftparam, leftparam.length - 1);
      Integer[] insert = (Integer[])Arrays.copyOf(rightparam, rightparam.length - 1);
      if (delete.length != 0) {
         this.service.deleteUserAndRole(userid, delete);
      }

      if (insert.length != 0) {
         this.service.saveUserAndRole(userid, insert);
      }

      return "success";
   }
}
