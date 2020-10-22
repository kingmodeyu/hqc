package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcUserPermission;
import com.hqc.user.service.IHqcUserPermissionService;
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
 * 员工权限表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-user-permission")
public class HqcUserPermissionController {

    @Autowired
    private IHqcUserPermissionService hqcUserPermissionService;

    @ApiOperation(value = "新增用户权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addUserPermission")
    public String addUserPermission(@RequestBody HqcUserPermission userPermission) {
        hqcUserPermissionService.save(userPermission);
        return "index";
    }

    @ApiOperation(value = "删除用户权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delUserPermission")
    public String delUserPermission(@RequestBody HqcUserPermission userPermission) {
        Wrapper<HqcUserPermission> queryWrapper = new QueryWrapper<HqcUserPermission>(userPermission);
        hqcUserPermissionService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新用户权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updUserPermission")
    public String updUserPermission(@RequestBody HqcUserPermission userPermission) {
        UpdateWrapper<HqcUserPermission> updateWrapperWrapper = new UpdateWrapper<HqcUserPermission>();
        updateWrapperWrapper.eq("userId",userPermission.getUserId());

        hqcUserPermissionService.update(userPermission,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询用户权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryUserPermission")
    public ModelAndView queryUserPermission(@RequestBody HqcUserPermission userPermission) {
        Wrapper<HqcUserPermission> queryWrapper = new QueryWrapper<HqcUserPermission>(userPermission);
        List<HqcUserPermission> list = hqcUserPermissionService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
