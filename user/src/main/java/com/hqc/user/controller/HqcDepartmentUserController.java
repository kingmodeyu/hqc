package com.hqc.user.controller;


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

    @RequestMapping("/test")
    public String user(Model model) {
        model.addAttribute("welcome","hello fishpro");
        return "index";
    }

}
