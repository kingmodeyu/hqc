package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcUserMenu;
import com.hqc.user.service.IHqcUserMenuService;
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
 * 员工菜单权限表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user/hqc-user-menu")
public class HqcUserMenuController {

    @Autowired
    private IHqcUserMenuService hqcUserMenuService;

    @ApiOperation(value = "新增用户菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/addUserMenu")
    public String addUserMenu(@RequestBody HqcUserMenu userMenu) {
        hqcUserMenuService.save(userMenu);
        return "index";
    }

    @ApiOperation(value = "删除用户菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/delUserMenu")
    public String delUserMenu(@RequestBody HqcUserMenu userMenu) {
        Wrapper<HqcUserMenu> queryWrapper = new QueryWrapper<HqcUserMenu>(userMenu);
        hqcUserMenuService.remove(queryWrapper);
        return "index";
    }

    @ApiOperation(value = "更新用户菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping("/updUserMenu")
    public String updUserMenu(@RequestBody HqcUserMenu userMenu) {
        UpdateWrapper<HqcUserMenu> updateWrapperWrapper = new UpdateWrapper<HqcUserMenu>();
        updateWrapperWrapper.eq("userId",userMenu.getUserId());

        hqcUserMenuService.update(userMenu,updateWrapperWrapper);
        return "index";
    }

    @ApiOperation(value = "查询用户菜单")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ModelAndView.class) })
    @RequestMapping("/queryUserMenu")
    public ModelAndView queryUserMenu(@RequestBody HqcUserMenu userMenu) {
        Wrapper<HqcUserMenu> queryWrapper = new QueryWrapper<HqcUserMenu>(userMenu);
        List<HqcUserMenu> list = hqcUserMenuService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }
}
