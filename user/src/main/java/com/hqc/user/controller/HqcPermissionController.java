package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcPermission;
import com.hqc.user.service.IHqcPermissionService;
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
 * 权限表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-permission")
public class HqcPermissionController {

    @Autowired
    private IHqcPermissionService HqcPermissionService;

    @ApiOperation(value = "新增权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addPermission")
    public String addPermission(@RequestBody HqcPermission permission) {
        HqcPermissionService.save(permission);
        return "index";
    }

    @ApiOperation(value = "删除权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delPermission")
    public String delPermission(@RequestBody HqcPermission permission) {
        Wrapper<HqcPermission> queryWrapper = new QueryWrapper<HqcPermission>(permission);
        HqcPermissionService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updPermission")
    public String updPermission(@RequestBody HqcPermission permission) {
        UpdateWrapper<HqcPermission> updateWrapperWrapper = new UpdateWrapper<HqcPermission>();
        updateWrapperWrapper.eq("permissionId",permission.getPermissionId());

        HqcPermissionService.update(permission,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询权限")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryPermission")
    public ModelAndView queryPermission(@RequestBody HqcPermission permission) {
        Wrapper<HqcPermission> queryWrapper = new QueryWrapper<HqcPermission>(permission);
        List<HqcPermission> list = HqcPermissionService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }
}
