package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcUserMenu;
import com.hqc.user.service.IHqcUserMenuService;
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

    @RequestMapping("/addUserMenu")
    public String addmenuGroup(@RequestBody HqcUserMenu userMenu) {
        hqcUserMenuService.save(userMenu);
        return "index";
    }

    @RequestMapping("/delUserMenu")
    public String delmenuGroup(@RequestBody HqcUserMenu userMenu) {
        Wrapper<HqcUserMenu> queryWrapper = new QueryWrapper<HqcUserMenu>(userMenu);
        hqcUserMenuService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updUserMenu")
    public String updmenuGroup(@RequestBody HqcUserMenu userMenu) {
        UpdateWrapper<HqcUserMenu> updateWrapperWrapper = new UpdateWrapper<HqcUserMenu>();
        updateWrapperWrapper.eq("userId",userMenu.getUserId());

        hqcUserMenuService.update(userMenu,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryUserMenu")
    public ModelAndView querymenuGroup(@RequestBody HqcUserMenu userMenu) {
        Wrapper<HqcUserMenu> queryWrapper = new QueryWrapper<HqcUserMenu>(userMenu);
        List<HqcUserMenu> list = hqcUserMenuService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }
}
