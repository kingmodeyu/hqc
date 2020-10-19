package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcRoleMenu;
import com.hqc.user.entity.HqcRolePermission;
import com.hqc.user.service.IHqcRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 角色菜单权限表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-role-permission")
public class HqcRolePermissionController {

    @Autowired
    private IHqcRolePermissionService hqcRolePermissionService;

    @RequestMapping("/addRolePermission")
    public String addmenuGroup(@RequestBody HqcRolePermission rolePermission) {
        hqcRolePermissionService.save(rolePermission);
        return "index";
    }

    @RequestMapping("/delRolePermission")
    public String delmenuGroup(@RequestBody HqcRolePermission rolePermission) {
        Wrapper<HqcRolePermission> queryWrapper = new QueryWrapper<HqcRolePermission>(rolePermission);
        hqcRolePermissionService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updRolePermission")
    public String updmenuGroup(@RequestBody HqcRolePermission rolePermission) {
        UpdateWrapper<HqcRolePermission> updateWrapperWrapper = new UpdateWrapper<HqcRolePermission>();
        updateWrapperWrapper.eq("roleId",rolePermission.getRoleId());

        hqcRolePermissionService.update(rolePermission,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryRolePermission")
    public ModelAndView querymenuGroup(@RequestBody HqcRolePermission rolePermission) {
        Wrapper<HqcRolePermission> queryWrapper = new QueryWrapper<HqcRolePermission>(rolePermission);
        List<HqcRolePermission> list = hqcRolePermissionService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }
}
