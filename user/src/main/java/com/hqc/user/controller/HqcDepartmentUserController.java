package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcDepartmentUser;
import com.hqc.user.service.IHqcDepartmentUserService;
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

    @ApiOperation(value = "新增部门用户")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addUser")
    public String addUser(@RequestBody HqcDepartmentUser user) {
        hqcDepartmentUserService.save(user);
        return "index";
    }

    @ApiOperation(value = "删除部门用户")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delUser")
    public String delUser(@RequestBody HqcDepartmentUser user) {
        Wrapper<HqcDepartmentUser> queryWrapper = new QueryWrapper<HqcDepartmentUser>(user);
        hqcDepartmentUserService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新部门用户")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updUser")
    public String updUser(@RequestBody HqcDepartmentUser user) {
        UpdateWrapper<HqcDepartmentUser> updateWrapperWrapper = new UpdateWrapper<HqcDepartmentUser>();
        updateWrapperWrapper.eq("userId",user.getUserId());

        hqcDepartmentUserService.update(user,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询部门用户")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryUser")
    public ModelAndView queryUser(@RequestBody HqcDepartmentUser user) {
        Wrapper<HqcDepartmentUser> queryWrapper = new QueryWrapper<HqcDepartmentUser>(user);
        List<HqcDepartmentUser> list = hqcDepartmentUserService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
