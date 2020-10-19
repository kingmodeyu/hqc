package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcPermissionGroup;
import com.hqc.user.entity.HqcRole;
import com.hqc.user.service.IHqcRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-role")
public class HqcRoleController {


    @Autowired
    private IHqcRoleService hqcRoleService;

    @RequestMapping("/addRole")
    public String addmenuGroup(@RequestBody HqcRole role) {
        hqcRoleService.save(role);
        return "index";
    }

    @RequestMapping("/delRole")
    public String delmenuGroup(@RequestBody HqcRole role) {
        Wrapper<HqcRole> queryWrapper = new QueryWrapper<HqcRole>(role);
        hqcRoleService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updRole")
    public String updmenuGroup(@RequestBody HqcRole role) {
        UpdateWrapper<HqcRole> updateWrapperWrapper = new UpdateWrapper<HqcRole>();
        updateWrapperWrapper.eq("roleId",role.getRoleId());

        hqcRoleService.update(role,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryRole")
    public ModelAndView querymenuGroup(@RequestBody HqcRole role) {
        Wrapper<HqcRole> queryWrapper = new QueryWrapper<HqcRole>(role);
        List<HqcRole> list = hqcRoleService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
