package com.hqc.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcRoleMenu;
import com.hqc.user.service.IHqcRoleMenuService;
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
@RequestMapping("/user/hqc-role-menu")
public class HqcRoleMenuController {

    @Autowired
    private IHqcRoleMenuService hqcRoleMenuService;

    @RequestMapping("/addRoleMenu")
    public String addmenuGroup(@RequestBody HqcRoleMenu roleMenu) {
        hqcRoleMenuService.save(roleMenu);
        return "index";
    }

    @RequestMapping("/delRoleMenu")
    public String delmenuGroup(@RequestBody HqcRoleMenu roleMenu) {
        Wrapper<HqcRoleMenu> queryWrapper = new QueryWrapper<HqcRoleMenu>(roleMenu);
        hqcRoleMenuService.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updRoleMenu")
    public String updmenuGroup(@RequestBody HqcRoleMenu roleMenu) {
        UpdateWrapper<HqcRoleMenu> updateWrapperWrapper = new UpdateWrapper<HqcRoleMenu>();
        updateWrapperWrapper.eq("menuId",roleMenu.getRoleId());

        hqcRoleMenuService.update(roleMenu,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryRoleMenu")
    public ModelAndView querymenuGroup(@RequestBody HqcRoleMenu roleMenu) {
        Wrapper<HqcRoleMenu> queryWrapper = new QueryWrapper<HqcRoleMenu>(roleMenu);
        List<HqcRoleMenu> list = hqcRoleMenuService.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
