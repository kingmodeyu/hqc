package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.service.IHqcDepartmentUserService;
import com.hqc.user.service.impl.HqcDepartmentUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 部门员工信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-09-17
 */
@Controller
@RequestMapping("/user/hqc-department-user")
public class HqcDepartmentUserController {

    @Autowired
    private IHqcDepartmentUserService hqcDepartmentUserService;

    @RequestMapping("/test")
    public String user(Model model) {
        model.addAttribute("welcome","hello fishpro");
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody HqcDepartmentUser user) {
        //model.addAttribute("welcome","hello fishpro");
        hqcDepartmentUserService.save(user);
        return "index";
    }

    @RequestMapping("/delUser")
    public String delUser(@RequestBody HqcDepartmentUser user) {
        //model.addAttribute("welcome","hello fishpro");
        Wrapper<HqcDepartmentUser> queryWrapper = new QueryWrapper<HqcDepartmentUser>(user);
        hqcDepartmentUserService.remove(queryWrapper);
        return "index";
    }

}
