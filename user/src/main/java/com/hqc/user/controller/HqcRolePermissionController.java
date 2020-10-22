package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcRoleMenu;
import com.hqc.user.entity.HqcRolePermission;
import com.hqc.user.service.IHqcRolePermissionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "新增角色权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addRolePermission")
    public String addRolePermission(@RequestBody HqcRolePermission rolePermission) {
        hqcRolePermissionService.save(rolePermission);
        return "index";
    }

    @ApiOperation(value = "删除角色权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delRolePermission")
    public String delRolePermission(@RequestBody HqcRolePermission rolePermission) {
        Wrapper<HqcRolePermission> queryWrapper = new QueryWrapper<HqcRolePermission>(rolePermission);
        hqcRolePermissionService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新角色权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updRolePermission")
    public String updRolePermission(@RequestBody HqcRolePermission rolePermission) {
        UpdateWrapper<HqcRolePermission> updateWrapperWrapper = new UpdateWrapper<HqcRolePermission>();
        updateWrapperWrapper.eq("roleId",rolePermission.getRoleId());

        hqcRolePermissionService.update(rolePermission,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询角色权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryRolePermission")
    public ModelAndView queryRolePermission(@RequestBody HqcRolePermission rolePermission) {
        Wrapper<HqcRolePermission> queryWrapper = new QueryWrapper<HqcRolePermission>(rolePermission);
        List<HqcRolePermission> list = hqcRolePermissionService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }
}
