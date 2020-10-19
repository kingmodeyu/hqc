package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.service.IHqcDepartmentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 部门员工信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-department-user")
public class HqcDepartmentUserController {

    @Autowired
    private IHqcDepartmentUserService hqcDepartmentUserService;

    @RequestMapping("/addUser")
    public String addUser(@RequestBody HqcDepartmentUser user) {
        hqcDepartmentUserService.save(user);
        return "index";
    }

    @RequestMapping("/delUser")
    public String delUser(@RequestBody HqcDepartmentUser user) {
        Wrapper<HqcDepartmentUser> queryWrapper = new QueryWrapper<HqcDepartmentUser>(user);
        hqcDepartmentUserService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updUser")
    public String updUser(@RequestBody HqcDepartmentUser user) {
        UpdateWrapper<HqcDepartmentUser> updateWrapperWrapper = new UpdateWrapper<HqcDepartmentUser>();
        updateWrapperWrapper.eq("userId",user.getUserId());

        hqcDepartmentUserService.update(user,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryUser")
    public ModelAndView queryUser(@RequestBody HqcDepartmentUser user) {
        Wrapper<HqcDepartmentUser> queryWrapper = new QueryWrapper<HqcDepartmentUser>(user);
        List<HqcDepartmentUser> list = hqcDepartmentUserService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
