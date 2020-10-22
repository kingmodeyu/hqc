package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcPermissionGroup;
import com.hqc.user.service.IHqcPermissionGroupService;
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
 * 权限组表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-permission-group")
public class HqcPermissionGroupController {

    @Autowired
    private IHqcPermissionGroupService hqcPermissionGroupService;

    @ApiOperation(value = "新增权限组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addPermissionGroup")
    public String addmenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        hqcPermissionGroupService.save(permissionGroup);
        return "index";
    }

    @ApiOperation(value = "删除权限组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delPermissionGroup")
    public String delmenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        Wrapper<HqcPermissionGroup> queryWrapper = new QueryWrapper<HqcPermissionGroup>(permissionGroup);
        hqcPermissionGroupService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新权限组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updPermissionGroup")
    public String updmenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        UpdateWrapper<HqcPermissionGroup> updateWrapperWrapper = new UpdateWrapper<HqcPermissionGroup>();
        updateWrapperWrapper.eq("permissionGroupId",permissionGroup.getPermissionGroupId());

        hqcPermissionGroupService.update(permissionGroup,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询权限组")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryPermissionGroup")
    public ModelAndView querymenuGroup(@RequestBody HqcPermissionGroup permissionGroup) {
        Wrapper<HqcPermissionGroup> queryWrapper = new QueryWrapper<HqcPermissionGroup>(permissionGroup);
        List<HqcPermissionGroup> list = hqcPermissionGroupService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
