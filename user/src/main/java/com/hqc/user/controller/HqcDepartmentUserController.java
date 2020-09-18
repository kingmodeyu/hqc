package com.hqc.user.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 部门员工信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-09-17
 */
@RestController
@RequestMapping("/user/hqc-department-user")
public class HqcDepartmentUserController {

    @GetMapping("/test")
    public ModelAndView user(Model model, @PathVariable Long id) {

        ModelAndView mav=new ModelAndView();
        mav.addObject("message", "SpringBoot 大爷你好！");
        mav.setViewName("helloWorld");
        return mav;
    }

}
