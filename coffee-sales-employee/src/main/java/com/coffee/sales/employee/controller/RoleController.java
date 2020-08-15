package com.coffee.sales.employee.controller;

import com.coffee.sales.employee.bean.Permission;
import com.coffee.sales.employee.bean.Role;
import com.coffee.sales.employee.service.impl.RoleServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"rolecont"})
public class RoleController {
   @Autowired
   private RoleServiceImpl service;

   @GetMapping({"getPage"})
   @ResponseBody
   public PageInfo<Role> getRoles(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) throws SQLException {
      PageHelper.startPage(pageNum, 5);
      List<Role> list = this.service.getAllRoles();
      PageInfo<Role> page = new PageInfo(list);
      return page;
   }

   @RequestMapping({"saveRole"})
   @ResponseBody
   public String saveRole(String name) throws SQLException {
      this.service.saveRole(name);
      return "success";
   }

   @RequestMapping({"updateRole"})
   @ResponseBody
   public String updateRole(Role role) throws SQLException {
      this.service.updateRole(role);
      return "update success";
   }

   @RequestMapping({"deleteRole"})
   @ResponseBody
   public String deleteRole(@RequestParam("ids[]") Integer[] ids) throws SQLException {
      this.service.deleteRole(ids);
      return "delete success";
   }

   @GetMapping({"permission"})
   public String toPermission(Integer id, Model model) throws SQLException {
      List<Permission> allPermissions = this.service.getAllPermission();
      List<Integer> permissionids = this.service.getPermission(id);
      model.addAttribute("allPermissions", allPermissions);
      model.addAttribute("permissionids", permissionids);
      model.addAttribute("id", id);
      return "user/assignPermission";
   }

   @GetMapping({"updatePermission"})
   @ResponseBody
   public String updateRolePermission(Integer roleid, @RequestParam("savepermissionid[]") Integer[] saveid, @RequestParam("deletepermissionid[]") Integer[] deleteid) throws SQLException {
      Integer[] save = (Integer[])Arrays.copyOf(saveid, saveid.length - 1);
      Integer[] delete = (Integer[])Arrays.copyOf(deleteid, deleteid.length - 1);
      if (save.length != 0) {
         this.service.saveRoleAndePermission(roleid, save);
      }

      if (delete.length != 0) {
         this.service.deleteRolePermission(roleid, delete);
      }

      return "update success";
   }
}
