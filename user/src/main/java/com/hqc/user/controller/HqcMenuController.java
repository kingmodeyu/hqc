package com.hqc.user.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hqc.user.entity.HqcMenu;
import com.hqc.user.service.IHqcMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author kingmodeyu
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/menu/hqc-menu")
public class HqcMenuController {

    @Autowired
    private IHqcMenuService hqcMenmenuvice;

    @RequestMapping("/addMenu")
    public String addmenu(@RequestBody HqcMenu menu) {
        hqcMenmenuvice.save(menu);
        return "index";
    }

    @RequestMapping("/delMenu")
    public String delmenu(@RequestBody HqcMenu menu) {
        Wrapper<HqcMenu> queryWrapper = new QueryWrapper<HqcMenu>(menu);
        hqcMenmenuvice.remove(queryWrapper);
        return "index";
    }

    @RequestMapping("/updMenu")
    public String updmenu(@RequestBody HqcMenu menu) {
        UpdateWrapper<HqcMenu> updateWrapperWrapper = new UpdateWrapper<HqcMenu>();
        updateWrapperWrapper.eq("menuId",menu.getMenuId());

        hqcMenmenuvice.update(menu,updateWrapperWrapper);
        return "index";
    }

    @RequestMapping("/queryMenu")
    public ModelAndView querymenu(@RequestBody HqcMenu menu) {
        Wrapper<HqcMenu> queryWrapper = new QueryWrapper<HqcMenu>(menu);
        List<HqcMenu> list = hqcMenmenuvice.list(queryWrapper);

        ModelAndView view = new ModelAndView();
        view.addObject("list",list);
        return view;
    }

}
