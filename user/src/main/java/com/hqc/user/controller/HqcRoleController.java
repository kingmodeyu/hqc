package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcPermissionGroup;
import com.hqc.user.entity.HqcRole;
import com.hqc.user.service.IHqcRoleService;
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

    @ApiOperation(value = "新增角色")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addRole")
    public String addRole(@RequestBody HqcRole role) {
        hqcRoleService.save(role);
        return "index";
    }

    @ApiOperation(value = "删除角色")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delRole")
    public String delRole(@RequestBody HqcRole role) {
        Wrapper<HqcRole> queryWrapper = new QueryWrapper<HqcRole>(role);
        hqcRoleService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新角色")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updRole")
    public String updRole(@RequestBody HqcRole role) {
        UpdateWrapper<HqcRole> updateWrapperWrapper = new UpdateWrapper<HqcRole>();
        updateWrapperWrapper.eq("roleId",role.getRoleId());

        hqcRoleService.update(role,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询角色")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryRole")
    public ModelAndView queryRole(@RequestBody HqcRole role) {
        Wrapper<HqcRole> queryWrapper = new QueryWrapper<HqcRole>(role);
        List<HqcRole> list = hqcRoleService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
