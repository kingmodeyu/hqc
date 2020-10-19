package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcUserPermission;
import com.hqc.user.entity.HqcUserRole;
import com.hqc.user.service.IHqcUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 员工角色表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-user-role")
public class HqcUserRoleController {

    @Autowired
    private IHqcUserRoleService hqcUserRoleService;

    @RequestMapping("/addUserRole")
    public String addmenuGroup(@RequestBody HqcUserRole userRole) {
        hqcUserRoleService.save(userRole);
        return "index";
    }

    @RequestMapping("/delUserRole")
    public String delmenuGroup(@RequestBody HqcUserRole userRole) {
        Wrapper<HqcUserRole> queryWrapper = new QueryWrapper<HqcUserRole>(userRole);
        hqcUserRoleService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updUserRole")
    public String updmenuGroup(@RequestBody HqcUserRole userRole) {
        UpdateWrapper<HqcUserRole> updateWrapperWrapper = new UpdateWrapper<HqcUserRole>();
        updateWrapperWrapper.eq("userId",userRole.getUserId());

        hqcUserRoleService.update(userRole,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryUserRole")
    public ModelAndView querymenuGroup(@RequestBody HqcUserRole userRole) {
        Wrapper<HqcUserRole> queryWrapper = new QueryWrapper<HqcUserRole>(userRole);
        List<HqcUserRole> list = hqcUserRoleService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
